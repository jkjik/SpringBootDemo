package com.example.demo.business.repository;

import com.example.demo.business.repository.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:08
 **/
@Repository
public interface IProductImageRepository extends JpaRepository<ProductImageEntity,Integer> {
    List<ProductImageEntity> findAllByProductNameAndIsdeleteFalse(String productName);
}
