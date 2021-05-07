package com.facturar.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturar.app.entity.UserEntity;
import com.facturar.app.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDaoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<UserEntity> findAll() {
		return userDaoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<UserEntity> findAll(Pageable pageable) {
		return userDaoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UserEntity> findById(Long id) {
		return userDaoRepository.findById(id);
	}

	@Override
	@Transactional
	public UserEntity save(UserEntity user) {
		return userDaoRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userDaoRepository.deleteById(id);
	}

}
