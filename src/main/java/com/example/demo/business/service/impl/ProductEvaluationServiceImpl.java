package com.example.demo.business.service.impl;

import com.example.demo.business.enums.StatusCodeEnum;
import com.example.demo.business.repository.IProductEvaluationRepository;
import com.example.demo.business.repository.IProductImageRepository;
import com.example.demo.business.repository.entity.ProductEvaluationEntity;
import com.example.demo.business.repository.entity.ProductImageEntity;
import com.example.demo.business.service.IProductEvaluationService;
import com.example.demo.business.util.HeadersUtil;
import com.example.demo.business.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cj
 * @description 软件反馈实现
 * @date: 2019/4/29 15:45
 **/
@Service
public class ProductEvaluationServiceImpl implements IProductEvaluationService {

    @Autowired
    private IProductEvaluationRepository productEvaluationRepository;
    @Autowired
    private IProductImageRepository productImageRepository;

    /**
     * 添加反馈
     * @param addProductEvaluationRequest
     * @return
     */
    @Override
    @Transactional
    public ResultVO<Boolean> addProductEvaluation(AddProductEvaluationRequest addProductEvaluationRequest) {
        //产品名称不能为空
        if(null == addProductEvaluationRequest || null == addProductEvaluationRequest.getProductName()){
            return ResultVO.newInstance(false, StatusCodeEnum.ERROR.getCode(),StatusCodeEnum.ERROR.getMessage());
        }
        ProductEvaluationEntity productEvaluationEntity = new ProductEvaluationEntity();
        BeanUtils.copyProperties(addProductEvaluationRequest,productEvaluationEntity);
        productEvaluationEntity.setImageNumber(addProductEvaluationRequest.getImageInfoList().size());
        productEvaluationRepository.save(productEvaluationEntity);
        //保存图片信息
        List<ProductImageEntity> productImageEntityList = new ArrayList<>();
        String productName = addProductEvaluationRequest.getProductName();
        if(null != addProductEvaluationRequest && 0 != addProductEvaluationRequest.getImageInfoList().size()){
            addProductEvaluationRequest.getImageInfoList().forEach(productImageInfo->{
                ProductImageEntity productImageEntity = new ProductImageEntity();
                BeanUtils.copyProperties(productImageInfo,productImageEntity);
                productImageEntity.setProductName(productName);
                productImageEntityList.add(productImageEntity);
            });
        }
        List<ProductImageEntity> resultList = productImageRepository.saveAll(productImageEntityList);
        if(addProductEvaluationRequest.getImageInfoList().size() != resultList.size()){
            return ResultVO.newInstance(false, StatusCodeEnum.SAVE_ERROR.getCode(),StatusCodeEnum.SAVE_ERROR.getMessage());
        }
        return ResultVO.newInstance(true);
    }

    /**
     * 列表表头
     * @return
     */
    @Override
    public List<PageHeadersResult> getPageHead() {
        return HeadersUtil.getHeaders(ProductEvaluationPageHeader.class);
    }

    /**
     * 分页查询
     * @param pageRequestQueryPageVO
     * @return
     */
    @Override
    public PageResult<ProductPageResult> productPage(QueryPageVO<ProductPageRequest> pageRequestQueryPageVO) {
        //构建查询条件
        ProductPageRequest productPageRequest = pageRequestQueryPageVO.getQuery();
        PageVO pageVO = pageRequestQueryPageVO.getPageInfo();
        Sort sort = new Sort(Sort.Direction.DESC, "modifytime");
        Pageable pageable = PageRequest.of(pageVO.getPage() - 1, pageVO.getSize(), sort);
        //查询
        Page<ProductEvaluationEntity> productEvaluationEntityPage =
                productEvaluationRepository.page(productPageRequest.getProductName(),productPageRequest.getFinallyScore(),pageable);
        List<ProductPageResult> productPageResultList = new ArrayList<>();
        productEvaluationEntityPage.forEach(productEvaluationEntity->{
            ProductPageResult productPageResult = new ProductPageResult();
            BeanUtils.copyProperties(productEvaluationEntity,productPageResult);
            productPageResultList.add(productPageResult);
        });
        return new PageResult<>(
                productPageResultList,
                productEvaluationEntityPage.getNumber(),
                productEvaluationEntityPage.getSize(),
                (int)productEvaluationEntityPage.getTotalElements(),
                productEvaluationEntityPage.getTotalPages());
    }
}
