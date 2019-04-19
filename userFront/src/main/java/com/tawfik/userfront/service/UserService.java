package com.tawfik.userfront.service;

import com.tawfik.userfront.domain.User;

public interface UserService {
	
	void saveUser(User user);
	User findByUsername(String username);
	User findByEmail(String email);
    boolean checkUsernameExist(String username);
    boolean checkEmailExists(String email);
	boolean checkUserExists(String username,String email);
	
}
