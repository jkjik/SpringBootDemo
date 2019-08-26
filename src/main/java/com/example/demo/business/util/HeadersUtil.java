package com.example.demo.business.util;

import com.example.demo.business.vo.PageHeadersResult;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: cj
 * @description 获得表头公共包
 * @date: 2019/4/29 16:14
 **/

public class HeadersUtil {
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Headers{
        String name();
    }

    public static List<PageHeadersResult> getHeaders(Class<?> clazz){
        List<PageHeadersResult> result = new ArrayList<>();
        if(clazz == Object.class){
            return result;
        }
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            Headers headers = field.getAnnotation(Headers.class);
            if(headers != null){
                result.add(new PageHeadersResult(field.getName(),headers.name()));
            }
        }
        result.addAll(getHeaders(clazz.getSuperclass()));
        return result;
    }
}
