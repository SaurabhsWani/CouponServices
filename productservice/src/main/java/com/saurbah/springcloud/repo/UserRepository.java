package com.saurbah.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.springcloud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
