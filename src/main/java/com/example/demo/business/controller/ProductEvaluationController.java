package com.example.demo.business.controller;

import com.example.demo.business.service.IProductEvaluationService;
import com.example.demo.business.service.IProductImageService;
import com.example.demo.business.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:12
 **/
@Api(value = "软件反馈",description = "新增反馈，查看列表")
@RestController
@RequestMapping("base/test/product")
public class ProductEvaluationController {
    @Autowired
    private IProductEvaluationService productEvaluationServiceImpl;
    @Autowired
    private IProductImageService productImageServiceImpl;

    @ApiOperation("新增反馈")
    @PostMapping("/addEvaluation")
    public ResultVO<Boolean> addProductEvaluation(@RequestBody AddProductEvaluationRequest addProductEvaluationRequest){
        return productEvaluationServiceImpl.addProductEvaluation(addProductEvaluationRequest);
    }

    @ApiOperation("获得列表表头")
    @GetMapping("/getPageHead")
    public List<PageHeadersResult> getPageHead(){
        return productEvaluationServiceImpl.getPageHead();
    }

    @ApiOperation("分页列表")
    @PostMapping("/productPage")
    public PageResult<ProductPageResult> productPage(@RequestBody QueryPageVO<ProductPageRequest> pageRequestQueryPageVO){
        return productEvaluationServiceImpl.productPage(pageRequestQueryPageVO);
    }

    @ApiOperation("图片详情")
    @GetMapping("/productImageInfo/{productName}")
    public ResultVO<List<ProductImageInfo>> productImageInfo(@PathVariable("productName") String productName){
        return productImageServiceImpl.productImageInfo(productName);
    }
}
