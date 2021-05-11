package com.facturar.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturar.app.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

}
