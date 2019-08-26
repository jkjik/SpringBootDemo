package com.example.demo.business.vo;

import com.example.demo.business.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:37
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private T result;
    private Integer code;
    private String message;

    public static <T> ResultVO<T> newInstance(T result, Integer code,String message) {
        return new ResultVO<>(result,code,message);
    }

    public static <T> ResultVO<T> newInstance(T result) {
        return new ResultVO<>(result, StatusCodeEnum.OK.getCode(), StatusCodeEnum.OK.getMessage());
    }
}
