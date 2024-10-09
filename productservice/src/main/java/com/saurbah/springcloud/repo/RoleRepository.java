package com.saurbah.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.springcloud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
