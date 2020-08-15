package com.weds.edwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import com.weds.core.base.BaseService;
import com.weds.edwx.mapper.CardMapper;
import com.weds.edwx.entity.CardEntity;

/**
 * @Author sxm
 * @Description Card管理
 * @Date 2019-02-26
 */
@Service
public class CardService extends BaseService {

    @Autowired
    private CardMapper cardMapper;

    private Logger log = LogManager.getLogger();

    public CardEntity getCardState(CardEntity card) {
        return cardMapper.getCardState(card);
    }
}
