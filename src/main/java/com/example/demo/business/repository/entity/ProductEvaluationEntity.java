package com.example.demo.business.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 14:48
 **/
@Getter
@Setter
@Entity
@Table(name = "business_product_evaluation")
public class ProductEvaluationEntity {
    @Id
    @GenericGenerator(name = "autoId", strategy = "native")
    @GeneratedValue(generator = "autoId")
    private Integer id;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("评分")
    private Integer finallyScore;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("图片数量")
    private Integer imageNumber;

    @ApiModelProperty("操作id")
    private String operatorid;

    @ApiModelProperty("是否删除")
    private Boolean isdelete;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;

    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifytime;

    public ProductEvaluationEntity() {
        Date newTime = new Date();
        this.isdelete = false;
        this.createtime = newTime;
        this.modifytime = newTime;
    }
}
