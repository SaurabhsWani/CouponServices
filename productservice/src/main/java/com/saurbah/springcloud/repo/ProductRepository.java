package com.saurbah.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.springcloud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
