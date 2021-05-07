package com.facturar.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.facturar.app.entity.UserEntity;

public interface UserService {
	
	public Iterable<UserEntity> findAll();
	
	public Page<UserEntity> findAll(Pageable pageable);
	
	public Optional<UserEntity> findById(Long id);
	
	public UserEntity save(UserEntity user);
	
	public void deleteById(Long id);
	
}
