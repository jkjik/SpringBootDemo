package com.example.demo.business.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: cj
 * @description 列表分页结果
 * @date: 2019/4/29 16:46
 **/
@Getter
@Setter
@NoArgsConstructor
public class ProductPageResult {
    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("评分")
    private Integer finallyScore;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("图片数量")
    private Integer imageNumber;
}
