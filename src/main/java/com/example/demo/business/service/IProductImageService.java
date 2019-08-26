package com.example.demo.business.service;

import com.example.demo.business.vo.ProductImageInfo;
import com.example.demo.business.vo.ResultVO;

import java.util.List;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 16:54
 **/

public interface IProductImageService {
    ResultVO<List<ProductImageInfo>> productImageInfo(String productName);
}
