package com.weds.edwx.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Date;

import com.weds.core.base.BaseController;
import com.weds.core.annotation.Logs;
import com.weds.core.utils.DateUtils;
import com.weds.core.resp.JsonResult;
import com.weds.core.base.BaseCommPager;
import com.weds.core.base.BasePageSearch;

import com.weds.edwx.entity.CardEntity;
import com.weds.edwx.service.CardService;

/**
 * @Author sxm
 * @Description Card管理
 * @Date 2019-02-26
 */
@RestController
@RequestMapping(value = "/card")
@Api(value = "Card管理", description = "Card管理")
public class CardController extends BaseController {
    @Autowired
    private CardService cardService;

    private Logger log = LogManager.getLogger();

    @Logs
    @ApiOperation(value = "获取卡片状态", notes = "获取卡片状态")
    @RequestMapping(value = "/getCardState", method = RequestMethod.POST)
    public JsonResult<Object> updateByPrimaryKey(@RequestBody CardEntity record) {
        CardEntity card = cardService.getCardState(record);
        if (card == null) {
            return failMsg("暂无卡片状态");
        }
        return succMsgData(card);
    }

}