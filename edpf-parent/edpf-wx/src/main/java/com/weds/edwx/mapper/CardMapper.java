package com.weds.edwx.mapper;

import com.weds.edwx.entity.CardEntity;
import com.weds.core.annotation.MyBatisDao;
import java.util.List;

/**
 * @Author
 * @Description 管理
 * @Date 2019-02-26
 */
@MyBatisDao
public interface CardMapper {
    CardEntity getCardState(CardEntity card);
}