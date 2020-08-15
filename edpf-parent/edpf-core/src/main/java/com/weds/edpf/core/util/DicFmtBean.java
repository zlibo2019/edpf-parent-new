package com.weds.edpf.core.util;

import com.weds.bean.base.DicFmtService;
import com.weds.core.base.BaseEntity;
import com.weds.edpf.core.entity.DictInfoEntity;
import com.weds.edpf.core.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author SXM
 */
@Component
public class DicFmtBean implements DicFmtService {
    @Autowired
    private DictInfoService dictInfoService;

    public void DicFormat(BaseEntity baseEn, String[] typeCodes) {
        List<DictInfoEntity> list = dictInfoService.selectListByType(Arrays.asList(typeCodes));
        DicFmtUtils.FormatDic(baseEn, list);
    }

    public void DicFormat(BaseEntity[] baseEns, String[] typeCodes) {
        List<DictInfoEntity> list = dictInfoService.selectListByType(Arrays.asList(typeCodes));
        DicFmtUtils.FormatDic(baseEns, list);
    }

    public void DicFormat(BaseEntity baseEn, String typeCode) {
        String[] typeCodes = {typeCode};
        this.DicFormat(baseEn, typeCodes);
    }

    public void DicFormat(BaseEntity[] baseEns, String typeCode) {
        String[] typeCodes = {typeCode};
        this.DicFormat(baseEns, typeCodes);
    }
}
