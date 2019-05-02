package com.example.demo.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: cj
 * @description 状态码枚举
 * @date: 2019/4/29 15:41
 **/
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    OK(1000,"成功"),
    ERROR(4000,"参数错误"),
    SAVE_ERROR(4001,"保存失败");
    private Integer code;
    private String message;
}
