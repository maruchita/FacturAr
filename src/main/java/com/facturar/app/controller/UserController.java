package com.facturar.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturar.app.entity.UserEntity;
import com.facturar.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create a new user

	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserEntity user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	// Read user

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {

		Optional<UserEntity> user = userService.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);

	}

	// Update User

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UserEntity userDetails, @PathVariable(value = "id") Long userId) {

		Optional<UserEntity> user = userService.findById(userId);

		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		// BeanUtils.copyProperties(userDetails, user.get());
		user.get().setName(userDetails.getName());
		user.get().setEmail(userDetails.getEmail());
		

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	//Delete

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {

		if (!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		userService.deleteById(userId);

		return new ResponseEntity<>("Se ha eliminado el usuario con id: " + userId, HttpStatus.OK);
	}
	
	
	//Read all
	
	@GetMapping
	public List<UserEntity> readAll(){
		
		List<UserEntity> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;
		
	}
	

}
