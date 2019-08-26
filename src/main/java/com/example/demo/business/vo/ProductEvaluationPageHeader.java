package com.example.demo.business.vo;

import com.example.demo.business.util.HeadersUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 16:32
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvaluationPageHeader {
    @HeadersUtil.Headers(name = "软件")
    @ApiModelProperty("产品名称")
    private String productName;
    @HeadersUtil.Headers(name = "评分")
    @ApiModelProperty("评分")
    private Integer finallyScore;
    @HeadersUtil.Headers(name = "描述")
    @ApiModelProperty("描述")
    private String description;
    @HeadersUtil.Headers(name = "图片数量")
    @ApiModelProperty("图片数量")
    private Integer imageNumber;
}
