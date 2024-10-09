package com.saurbah.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.saurbah.springcloud.dto.Coupon;
import com.saurbah.springcloud.model.Product;
import com.saurbah.springcloud.repo.ProductRepository;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	RestTemplate restTemplate;

	@Value("${coupon-url}")
	private String couponUrl;

	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		restTemplate = new RestTemplateBuilder().basicAuthentication("r@wani.com", "john").build();
		Coupon coupon = restTemplate.getForObject(couponUrl + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);
	}

	@GetMapping("/products")
	public List<Product> getallProducts() {
		return productRepository.findAll();
	}

}
