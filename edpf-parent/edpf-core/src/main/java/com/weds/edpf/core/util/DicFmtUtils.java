package com.weds.edpf.core.util;

import com.weds.core.base.BaseEntity;
import com.weds.core.utils.ClassUtils;
import com.weds.edpf.core.annotation.Dict;
import com.weds.edpf.core.entity.DictInfoEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author SXM
 */
public class DicFmtUtils {

    /**
     * @param className
     * @return
     */
    public static List<Map<String, String>> findAttInfo(String className) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Class<?> clazz = Class.forName(className);
            for (Field field : clazz.getDeclaredFields()) {
                for (Annotation annotation : field.getAnnotations()) {
                    if (annotation instanceof Dict) {
                        Map<String, String> map = new HashMap<String, String>();
                        String fieldName = field.getName();
                        String dicCode = ((Dict) annotation).value();
                        map.put("fieldName", fieldName);
                        map.put("dicCode", dicCode);
                        list.add(map);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param baseEn
     * @param dics
     */
    public static void FormatDic(BaseEntity baseEn, Map<String, Object> dics) {
        List<Map<String, String>> attInfo = findAttInfo(baseEn.getClass().getName());
        for (Map<String, String> map : attInfo) {
            String fieldName = map.get("fieldName");
            String dicCode = map.get("dicCode");
            Object obj = ClassUtils.getFieldValueByName(fieldName, baseEn);
            String dicId = obj == null ? "" : obj.toString();
            baseEn.getDicFmtMap().put(fieldName + "Cn", dicId);
            if (!"".equals(dicId) && dics != null) {
                Iterator iterator = dics.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next().toString();
                    if (key.equals(dicCode)) {
                        List<Map<String, Object>> list = (List<Map<String, Object>>) dics.get(key);
                        for (Map<String, Object> temp : list) {
                            String dic = temp.get("dic_code").toString();
                            if (dic.equals(dicId)) {
                                baseEn.getDicFmtMap().put(fieldName + "Cn", temp.get("dic_name").toString());
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @param en
     * @return
     * @throws Exception
     */
    public static BaseEntity[] FormatDic(BaseEntity[] en, Map<String, Object> dics) {
        if (en.length > 0) {
            for (BaseEntity baseEn : en) {
                FormatDic(baseEn, dics);
            }
        }
        return en;
    }

    /**
     * @param baseEn
     * @param dicList
     */
    public static void FormatDic(BaseEntity baseEn, List<DictInfoEntity> dicList) {
        List<Map<String, String>> attInfo = findAttInfo(baseEn.getClass().getName());
        for (Map<String, String> map : attInfo) {
            String fieldName = map.get("fieldName");
            String dicCode = map.get("dicCode");
            Object obj = ClassUtils.getFieldValueByName(fieldName, baseEn);
            String dicId = obj == null ? "" : obj.toString();
            baseEn.getDicFmtMap().put(fieldName + "Cn", dicId);
            if (!"".equals(dicId) && dicList != null) {
                for (DictInfoEntity dictInfoEntity : dicList) {
                    String type = dictInfoEntity.getTypeCode();
                    String code = dictInfoEntity.getDicCode();
                    if (type.equals(dicCode) && code.equals(dicId)) {
                        baseEn.getDicFmtMap().put(fieldName + "Cn", dictInfoEntity.getDicName());
                        continue;
                    }
                }
            }
        }
    }

    /**
     * @param en
     * @return
     * @throws Exception
     */
    public static BaseEntity[] FormatDic(BaseEntity[] en, List<DictInfoEntity> dicList) {
        if (en.length > 0) {
            for (BaseEntity baseEn : en) {
                FormatDic(baseEn, dicList);
            }
        }
        return en;
    }
}
