package com.example.demo.business.repository;

import com.example.demo.business.repository.entity.ProductEvaluationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/4/29 15:06
 **/
@Repository
public interface IProductEvaluationRepository extends JpaRepository<ProductEvaluationEntity,Integer> {
    @Query(value = "select p from ProductEvaluationEntity as p where isdelete = false " +
            "and (:productName is null or p.productName =:productName)" +
            "and (:finallyScore is null or p.finallyScore =:finallyScore) " +
            "")
    Page<ProductEvaluationEntity> page(@Param("productName") String productName, @Param("finallyScore") Integer finallyScore, Pageable pageable);
}
