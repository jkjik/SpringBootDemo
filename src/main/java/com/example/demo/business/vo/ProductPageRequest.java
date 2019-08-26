package com.example.demo.business.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: cj
 * @description 列表分页请求
 * @date: 2019/4/29 16:41
 **/
@Getter
@Setter
@NoArgsConstructor
public class ProductPageRequest {
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("评分")
    private Integer finallyScore;
}
