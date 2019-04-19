package com.tawfik.userfront.repository;

import org.springframework.data.repository.CrudRepository;

import com.tawfik.userfront.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
	User findByEmail(String email);
	

}
