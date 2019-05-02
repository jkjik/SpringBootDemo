package com.example.demo.business.service.impl;

import com.example.demo.business.repository.IProductImageRepository;
import com.example.demo.business.repository.entity.ProductImageEntity;
import com.example.demo.business.service.IProductImageService;
import com.example.demo.business.vo.ProductImageInfo;
import com.example.demo.business.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cj
 * @description 软件反馈图片实现
 * @date: 2019/4/29 16:55
 **/
@Service
public class ProductImageServiceImpl implements IProductImageService {
    @Autowired
    private IProductImageRepository productImageRepository;


    /**
     * 根据产品名称查询反馈图片
     * @param productName
     * @return
     */
    @Override
    public ResultVO<List<ProductImageInfo>> productImageInfo(String productName) {
        List<ProductImageEntity> productImageEntityList =
                productImageRepository.findAllByProductNameAndIsdeleteFalse(productName);
        List<ProductImageInfo> productImageInfoList = new ArrayList<>();
        if(null != productImageEntityList && 0 != productImageEntityList.size()){
            productImageEntityList.forEach(productImageEntity->{
                ProductImageInfo productImageInfo = new ProductImageInfo();
                BeanUtils.copyProperties(productImageEntity,productImageInfo);
                productImageInfoList.add(productImageInfo);
            });
        }
        return ResultVO.newInstance(productImageInfoList);
    }
}
