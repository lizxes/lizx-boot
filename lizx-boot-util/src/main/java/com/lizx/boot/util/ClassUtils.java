package com.lizx.boot.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by art on 2016/7/20.
 */
public class ClassUtils {
    private ClassUtils(){}

    public static Map<String, Object> toMap(Object object){
        Map<String, Object> map = new HashMap<>();

        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            Object val = null;
            try {
                val = field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(val != null){
                map.put(field.getName(), val);
            }
        }
        return map;
    }



}
