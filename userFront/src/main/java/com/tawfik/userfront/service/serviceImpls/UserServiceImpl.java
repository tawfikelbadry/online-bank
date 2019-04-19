package com.tawfik.userfront.service.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tawfik.userfront.domain.User;
import com.tawfik.userfront.repository.UserRepository;
import com.tawfik.userfront.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean checkUsernameExist(String username) {
		if (userRepository.findByUsername(username) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmailExists(String email) {
		if (userRepository.findByEmail(email) == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExist(username)||checkEmailExists(email)) {
			return true;
		}
		return false;
	}

}
