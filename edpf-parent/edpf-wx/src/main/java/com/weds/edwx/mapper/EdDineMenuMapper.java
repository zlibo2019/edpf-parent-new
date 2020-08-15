package com.weds.edwx.mapper;

import com.weds.edwx.entity.EdDineMenuEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author
 * @Description 菜谱定义管理
 * @Date 2019-04-15
 */
@MyBatisDao
public interface EdDineMenuMapper {
    /**
     */
    int deleteByPrimaryKey(String menuId);

    /**
     */
    int insert(EdDineMenuEntity record);

    /**
     */
    int insertSelective(EdDineMenuEntity record);

    /**
     */
    EdDineMenuEntity selectByPrimaryKey(String menuId);

    /**
     */
    int updateByPrimaryKeySelective(EdDineMenuEntity record);

    /**
     */
    int updateByPrimaryKey(EdDineMenuEntity record);

    /**
     */
    List<EdDineMenuEntity> selectListByEntity(EdDineMenuEntity record);

    /**
     */
    List<EdDineMenuEntity> selectListByKeys(@Param("keys") String keys);

    /**
     */
    int deleteBatchByKeys(@Param("list") List<EdDineMenuEntity> list);
}