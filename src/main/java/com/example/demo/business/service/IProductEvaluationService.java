package com.example.demo.business.service;

import com.example.demo.business.vo.*;

import java.util.List;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:44
 **/

public interface IProductEvaluationService {
    ResultVO<Boolean> addProductEvaluation(AddProductEvaluationRequest addProductEvaluationRequest);

    List<PageHeadersResult> getPageHead();

    PageResult<ProductPageResult> productPage(QueryPageVO<ProductPageRequest> pageRequestQueryPageVO);
}
