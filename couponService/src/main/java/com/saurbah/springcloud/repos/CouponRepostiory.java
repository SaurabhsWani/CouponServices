package com.saurbah.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.springcloud.model.Coupon;

public interface CouponRepostiory extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
