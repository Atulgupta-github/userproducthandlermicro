package com.test.producthandler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.producthandler.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	String queryForProductByuserId="select * from product where user_id = :userId";
	@Query(value = queryForProductByuserId ,nativeQuery = true)
	List<Product> findAllProdcutsByUserId(@Param("userId") Integer userId);

}
