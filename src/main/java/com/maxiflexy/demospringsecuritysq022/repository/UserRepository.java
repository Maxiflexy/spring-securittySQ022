package com.maxiflexy.demospringsecuritysq022.repository;

import com.maxiflexy.demospringsecuritysq022.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
