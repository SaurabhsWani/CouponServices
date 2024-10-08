package com.saurbah.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurbah.springcloud.model.Coupon;
import com.saurbah.springcloud.repos.CouponRepostiory;

@RestController
@RequestMapping("/couponapi")
public class Controller {

	@Autowired
	CouponRepostiory couponRepostiory;

	@PostMapping("/coupons")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepostiory.save(coupon);
	}

	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable String code) {
		return couponRepostiory.findByCode(code);
	}
}
