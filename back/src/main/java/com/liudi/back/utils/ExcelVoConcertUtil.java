package com.liudi.back.utils;

import com.liudi.back.core.base.ExcelProperty;
import com.liudi.back.core.base.ExcelVo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelVoConcertUtil<T> {
    public ExcelVoConcertUtil() {
    }

    public static List<ExcelVo> voConcert(Class clazz) {
        List<ExcelVo> list = new ArrayList();
        List<Field> tempFields = new ArrayList();
        tempFields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Iterator var3 = tempFields.iterator();

        while(var3.hasNext()) {
            Field field = (Field)var3.next();
            if (field.isAnnotationPresent(ExcelProperty.class)) {
                ExcelVo excelVo = new ExcelVo();
                excelVo = putToField(field, (ExcelProperty)field.getAnnotation(ExcelProperty.class), excelVo);
                list.add(excelVo);
            }
        }

        return list;
    }

    private static ExcelVo putToField(Field field, ExcelProperty attr, ExcelVo excelVo) {
        if (attr != null) {
            String value = attr.name();
            String key = field.getName();
            excelVo.setKey(key);
            excelVo.setValue(value);
        }

        return excelVo;
    }
}
