package com.weds.edpf.core.service;

import com.alibaba.fastjson.JSONObject;
import com.weds.bean.jwt.JwtEntity;
import com.weds.bean.jwt.JwtParams;
import com.weds.bean.jwt.JwtUtils;
import com.weds.core.utils.FileUtils;
import com.weds.core.utils.ImageUtils;
import com.weds.core.utils.StringUtils;
import com.weds.edpf.core.constant.ScmParams;
import com.weds.edpf.core.constant.SystemPool;
import com.weds.edpf.core.constant.WeiXinParams;
import com.weds.edpf.core.entity.DtFaceEntity;
import com.weds.edpf.core.entity.DtPhotoEntity;
import com.weds.edpf.core.entity.WtPublicEntity;
import com.weds.edpf.core.mapper.DtFaceMapper;
import com.weds.edpf.core.mapper.DtPhotoMapper;
import com.weds.edpf.core.mapper.WtPublicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edpf.core.mapper.UserBaseMapper;
import com.weds.edpf.core.entity.UserBaseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author sxm
 * @Description 用户档案表管理
 * @Date 2019-05-23
 */
@Service
public class UserBaseService extends BaseService {

    @Resource
    private UserBaseMapper userBaseMapper;

    @Resource
    private DtFaceMapper dtFaceMapper;

    @Resource
    private DtPhotoMapper dtPhotoMapper;

    @Resource
    private WtPublicMapper wtPublicMapper;

    @Resource
    private CommonService commonService;

    @Resource
    private WeiXinParams weiXinParams;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ScmParams scmParams;

    private Logger log = LogManager.getLogger();

    @Transactional
    public int deleteByPrimaryKey(Long userSerial, String ip, String gly) {
        this.deleteFaceOrPhoto(userSerial);
        WtPublicEntity wtPublicEntity = new WtPublicEntity();
        wtPublicEntity.setLx(32);
        wtPublicEntity.setIsAll(0);
        wtPublicEntity.setLogType(1);
        wtPublicEntity.setUserSerial(userSerial);
        wtPublicEntity.setLogSj(new Date());
        wtPublicEntity.setLogIp(ip);
        wtPublicEntity.setGlyNo(gly);
        wtPublicMapper.insertSelective(wtPublicEntity);

        wtPublicEntity.setLx(3);
        wtPublicEntity.setIsAll(0);
        wtPublicEntity.setLogType(2);
        wtPublicEntity.setUserSerial(userSerial);
        wtPublicEntity.setLogSj(new Date());
        wtPublicEntity.setLogIp(ip);
        wtPublicEntity.setGlyNo(gly);
        wtPublicMapper.insertSelective(wtPublicEntity);
        return userBaseMapper.deleteByPrimaryKey(userSerial);
    }

    public int insert(UserBaseEntity record) {
        return userBaseMapper.insert(record);
    }

    public int insertSelective(UserBaseEntity record) throws Exception {
        if (!StringUtils.isBlank(record.getUserFacePhoto())) {
            String path;
            String dir;
            Date date = new Date();
            if (scmParams.getFaceType().equals("1")) {
                record.setUserFace(2);
                DtFaceEntity dtFaceEntity = new DtFaceEntity();
                dtFaceEntity.setUserSerial(record.getUserSerial());
                dtFaceEntity.setLx(0);
                dtFaceEntity.setGlyNo(record.getUserSerial().toString());
                dtFaceEntity.setFaceName(record.getUserSerial().toString() + ".fct");
                dtFaceEntity.setFaceType(0);
                dtFaceEntity.setFacePath("../../wwwroot/face/" + (record.getUserSerial() / 1000) + "/");
                dtFaceEntity.setSj(date);
                dtFaceMapper.insertSelective(dtFaceEntity);
                dir = scmParams.getFacePath() + File.separator + (record.getUserSerial() / 1000);
            } else {
                record.setUserPhoto(1);
                DtPhotoEntity dtPhotoEntity = new DtPhotoEntity();
                dtPhotoEntity.setUserSerial(record.getUserSerial());
                dtPhotoEntity.setLx(0);
                dtPhotoEntity.setGlyNo(record.getUserSerial().toString());
                dtPhotoEntity.setPhotoName(record.getUserSerial().toString() + ".jpg");
                dtPhotoEntity.setPhotoType(0);
                dtPhotoEntity.setPhotoPath("../photo/" + (record.getUserSerial() / 1000) + "/");
                dtPhotoEntity.setSj(date);
                dtPhotoMapper.insertSelective(dtPhotoEntity);
                dir = scmParams.getPhotoPath() + File.separator + (record.getUserSerial() / 1000);
            }
            path = ImageUtils.base64ToFile(record.getUserFacePhoto(), record.getUserSerial().toString() + "_0",
                    "jpg", dir, scmParams.getRootPath());
            commonService.makeFctFile(path);

            if (scmParams.getFaceType().equals("1") && scmParams.isUserPhoto()) {
                this.saveUserPhoto(record, date);
            }
        }
        return userBaseMapper.insertSelective(record);
    }

    public UserBaseEntity selectByPrimaryKey(Long userSerial) {
        return userBaseMapper.selectByPrimaryKey(userSerial);
    }

    public UserBaseEntity selectByCardNo(String userCard) {
        return userBaseMapper.selectByCardNo(userCard);
    }

    @Transactional
    public UserBaseEntity deleteFaceOrPhoto(Long userSerial) {
        boolean flag = false;
        UserBaseEntity entity = userBaseMapper.selectByPrimaryKey(userSerial);
        StringBuilder path = new StringBuilder();
        path.append(scmParams.getRootPath()).append(File.separator);
        if (scmParams.getFaceType().equals("1")) {
            if (entity.getUserFace() != null) {
                int userFace = entity.getUserFace() / 2 % 2;
                if (userFace == 1) {
                    entity.setUserFace(entity.getUserFace() - 2);
                }
                dtFaceMapper.deleteByPrimaryKey(userSerial);
                path.append(scmParams.getFacePath());
                flag = true;
            }
        } else {
            if (entity.getUserPhoto() != null) {
                entity.setUserPhoto(0);
                dtPhotoMapper.deleteByPrimaryKey(userSerial);
                path.append(scmParams.getPhotoPath());
                flag = true;
            }
        }

        if (flag) {
            path.append(File.separator).append(entity.getUserSerial() / 1000);
            File file = new File(path.toString());
            File[] files = file.listFiles(pathname -> pathname.getName().contains(entity.getUserSerial().toString()));
            if (files != null) {
                for (File item : files) {
                    item.delete();
                }
            }
        }

        return entity;
    }

    public void updateFaceOrPhoto(UserBaseEntity record) throws Exception {
        if (!StringUtils.isBlank(record.getUserFacePhoto())) {
            String path;
            String dir;
            Date date = new Date();
            UserBaseEntity entity = userBaseMapper.selectByPrimaryKey(record.getUserSerial());
            if (scmParams.getFaceType().equals("1")) {
                if (entity.getUserFace() != null) {
                    int userFace = entity.getUserFace() / 2 % 2;
                    if (userFace == 0) {
                        record.setUserFace(entity.getUserFace() + 2);
                    } else {
                        record.setUserFace(entity.getUserFace());
                    }
                } else {
                    record.setUserFace(2);
                }

                DtFaceEntity dtFaceEntity = new DtFaceEntity();
                dtFaceEntity.setUserSerial(record.getUserSerial());
                dtFaceEntity.setLx(0);
                dtFaceEntity.setGlyNo(record.getUserSerial().toString());
                dtFaceEntity.setFaceName(record.getUserSerial().toString() + ".fct");
                dtFaceEntity.setFaceType(0);
                dtFaceEntity.setFacePath("../../wwwroot/face/" + (record.getUserSerial() / 1000) + "/");
                dtFaceEntity.setSj(date);
                int flag = dtFaceMapper.updateByPrimaryKeySelective(dtFaceEntity);
                if (flag == 0) {
                    dtFaceMapper.insertSelective(dtFaceEntity);
                }
                dir = scmParams.getFacePath() + File.separator + (record.getUserSerial() / 1000);
            } else {
                record.setUserPhoto(1);
                DtPhotoEntity dtPhotoEntity = new DtPhotoEntity();
                dtPhotoEntity.setUserSerial(record.getUserSerial());
                dtPhotoEntity.setLx(0);
                dtPhotoEntity.setGlyNo(record.getUserSerial().toString());
                dtPhotoEntity.setPhotoName(record.getUserSerial().toString() + ".jpg");
                dtPhotoEntity.setPhotoType(0);
                dtPhotoEntity.setPhotoPath("../photo/" + (record.getUserSerial() / 1000) + "/");
                dtPhotoEntity.setSj(date);
                int flag = dtPhotoMapper.updateByPrimaryKeySelective(dtPhotoEntity);
                if (flag == 0) {
                    dtPhotoMapper.insertSelective(dtPhotoEntity);
                }
                dir = scmParams.getPhotoPath() + File.separator + (record.getUserSerial() / 1000);
            }

            if ("1".equals(record.getType())) {
                path = wxImageDownLoad(record.getUserFacePhoto(), record.getUserSerial().toString() + "_0",
                        "jpg", dir, scmParams.getPhotoSize(), scmParams.getRootPath());
            } else {
                path = ImageUtils.base64ToFile(record.getUserFacePhoto(), record.getUserSerial().toString() + "_0",
                        "jpg", dir, scmParams.getRootPath());
            }
            commonService.makeFctFile(path);

            if (scmParams.getFaceType().equals("1") && scmParams.isUserPhoto() && (entity.getUserPhoto() == null
                    || entity.getUserPhoto() != 1)) {
                this.saveUserPhoto(record, date);
            }
        }
    }

    @Transactional
    public int updateByPrimaryKeySelective(UserBaseEntity record, String ip, String gly) {
        WtPublicEntity wtPublicEntity = new WtPublicEntity();
        wtPublicEntity.setLx(32);
        wtPublicEntity.setIsAll(0);
        wtPublicEntity.setLogType(1);
        wtPublicEntity.setUserSerial(record.getUserSerial());
        wtPublicEntity.setLogSj(new Date());
        wtPublicEntity.setLogIp(ip);
        wtPublicEntity.setGlyNo(gly);
        wtPublicMapper.insertSelective(wtPublicEntity);

        wtPublicEntity.setLx(1);
        wtPublicEntity.setIsAll(0);
        wtPublicEntity.setLogType(2);
        wtPublicEntity.setUserSerial(record.getUserSerial());
        wtPublicEntity.setLogSj(new Date());
        wtPublicEntity.setLogIp(ip);
        wtPublicEntity.setGlyNo(gly);
        wtPublicMapper.insertSelective(wtPublicEntity);

        return userBaseMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserBaseEntity record) {
        return userBaseMapper.updateByPrimaryKey(record);
    }

    public List<UserBaseEntity> selectListByEntity(UserBaseEntity record) {
        return userBaseMapper.selectListByEntity(record);
    }


    public List<UserBaseEntity> selectListByKeys(String keys, String userDeps) {
        return userBaseMapper.selectListByKeys(keys, userDeps);
    }

    public UserBaseEntity userLoginCheck(UserBaseEntity record) {
        return userBaseMapper.userLoginCheck(record);
    }

    public int deleteBatchByKeys(List<UserBaseEntity> list) {
        return userBaseMapper.deleteBatchByKeys(list);
    }

    public List<UserBaseEntity> selectUserList(String userInfo) {
        return userBaseMapper.selectUserList(userInfo);
    }

    public List<UserBaseEntity> selectVisUserByDept(UserBaseEntity record) {
        return userBaseMapper.selectVisUserByDept(record);
    }

    public String getToken(UserBaseEntity userBaseEntity, JwtParams jwtParams) {
        JwtEntity jwtEntity = new JwtEntity();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userSerial", userBaseEntity.getUserSerial());
        jsonObject.put("companyId", userBaseEntity.getOrgId());
        jwtEntity.setJwtParams(jwtParams);
        jwtEntity.setPdata(jsonObject);
        String token = "";
        try {
            token = JwtUtils.createJWT(jwtEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    private void saveUserPhoto(UserBaseEntity record, Date date) throws IOException {
        record.setUserPhoto(1);
        DtPhotoEntity dtPhotoEntity = new DtPhotoEntity();
        dtPhotoEntity.setUserSerial(record.getUserSerial());
        dtPhotoEntity.setLx(0);
        dtPhotoEntity.setGlyNo(record.getUserSerial().toString());
        dtPhotoEntity.setPhotoName(record.getUserSerial().toString() + ".jpg");
        dtPhotoEntity.setPhotoType(0);
        dtPhotoEntity.setPhotoPath("../photo/" + (record.getUserSerial() / 1000) + "/");
        dtPhotoEntity.setSj(date);
        int flag = dtPhotoMapper.updateByPrimaryKeySelective(dtPhotoEntity);
        if (flag == 0) {
            dtPhotoMapper.insertSelective(dtPhotoEntity);
        }
        String source = scmParams.getRootPath() + File.separator + scmParams.getFacePath() + File.separator
                + (record.getUserSerial() / 1000) + File.separator
                + record.getUserSerial().toString() + "_0.jpg";
        String target = scmParams.getRootPath() + File.separator + scmParams.getPhotoPath() + File.separator
                + (record.getUserSerial() / 1000) + File.separator
                + record.getUserSerial().toString() + ".jpg";
        FileUtils.copyFile(new File(source), new File(target));
    }

    private String wxImageDownLoad(String mediaId, String fileName, String imageType,
                                   String imagePath, int size, String root) throws Exception {
        if (StringUtils.isBlank(mediaId)) {
            return null;
        }
        byte[] image;
        if (mediaId.startsWith("http")) {
            image = restTemplate.getForObject(mediaId, byte[].class);
        } else {
            image = restTemplate.getForObject(weiXinParams.getImageUrl(), byte[].class, SystemPool.getToken(), mediaId);
            String rtn = new String(image);
            if (rtn.contains("errcode")) {
                throw new RuntimeException();
            }
        }
        return ImageUtils.byteToImageScale(image, fileName, imageType, imagePath, root, size);
    }

    public void setUserBaseEntity(UserBaseEntity entity) {
        if ("1".equals(scmParams.getFaceType())) {
            if (entity.getUserFace() != null) {
                int userFace = entity.getUserFace() / 2 % 2;
                if (userFace == 1) {
                    String path = scmParams.getRootPath() + File.separator + scmParams.getFacePath() + File.separator
                            + entity.getUserSerial() / 1000 + File.separator + entity.getUserSerial() + "_0.jpg";
                    try {
                        entity.setUserFacePhoto(ImageUtils.imgToBase64(path));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            if (entity.getUserPhoto() != null && entity.getUserPhoto() == 1) {
                String path = scmParams.getRootPath() + File.separator + scmParams.getPhotoPath() + File.separator
                        + entity.getUserSerial() / 1000 + File.separator + entity.getUserSerial() + ".jpg";
                try {
                    entity.setUserFacePhoto(ImageUtils.imgToBase64(path));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
