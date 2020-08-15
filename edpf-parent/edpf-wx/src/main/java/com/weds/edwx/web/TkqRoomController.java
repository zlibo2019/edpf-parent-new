package com.weds.edwx.web;

import com.weds.core.annotation.Logs;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BaseController;
import com.weds.core.base.BasePageSearch;
import com.weds.core.resp.JsonResult;
import com.weds.edwx.entity.MeetRoomEntity;
import com.weds.edwx.entity.RoomResourceEntity;
import com.weds.edwx.entity.TimeEntity;
import com.weds.edwx.entity.TkqRoomEntity;
import com.weds.edwx.service.TkqRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sxm
 * @Description TkqRoom管理
 * @Date 2018-11-14
 */
@RestController
@RequestMapping(value = "/tkqRoom")
@Api(value = "TkqRoom管理", description = "会议室管理")
public class TkqRoomController extends BaseController {
    @Autowired
    private TkqRoomService tkqRoomService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "查询会议室列表和会议室当前状态", notes = "查询会议室列表和会议室当前状态")
    @RequestMapping(value = "/selectListPageByEntity", method = RequestMethod.POST)
    public JsonResult<BaseCommPager<MeetRoomEntity>> selectListPageByEntity(@RequestBody BasePageSearch<TimeEntity> record) {
        try {
            //分页处理
            setPageHelper(record);
            TimeEntity entity = record.getSearch();
            if (entity == null) {
                entity = new TimeEntity();
            }
            //传参为 cdate 当前日期 string
            List<MeetRoomEntity> list = tkqRoomService.selectRoomListByEntity(entity);
            List<MeetRoomEntity> list2 = new ArrayList<MeetRoomEntity>();
            for (int i = 0; i < list.size(); i++) {
                MeetRoomEntity meetRoomEntity = list.get(i);
                List<RoomResourceEntity> roomResource = tkqRoomService.getRoomResourceList(meetRoomEntity.getDepSerial());
                meetRoomEntity.setRoomResource(roomResource);
                list2.add(i, meetRoomEntity);
            }
            BaseCommPager<MeetRoomEntity> baseCommPager = new BaseCommPager<>(list);
            baseCommPager.setRecords(list2);
            return succMsgData(baseCommPager);
        } catch (Exception e) {
            return failMsg("传入的时间格式有误");
        }
    }

    @Logs
    @ApiOperation(value = "获取会议室信息", notes = "获取会议室信息")
    @RequestMapping(value = "/selectTkqRoomInfo", method = RequestMethod.GET)
    public JsonResult<Object> selectTkqRoomInfo(Integer depSerial) {
        TkqRoomEntity entity = tkqRoomService.selectByPrimaryKey(depSerial);
        return succMsgData(entity);
    }
}
