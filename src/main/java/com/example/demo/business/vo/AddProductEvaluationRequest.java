package com.example.demo.business.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:30
 **/
@Getter
@Setter
@NoArgsConstructor
public class AddProductEvaluationRequest {
    @ApiModelProperty("软件名称")
    private String productName;

    @ApiModelProperty("评分")
    private Integer finallyScore;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("图片信息")
    private List<ProductImageInfo> imageInfoList;
}
