package com.test.userhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.userhandler.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
