package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
	
		 User save = userRepository.save(user);
	if(null!=save) {
		return save;
	}
	return null;
	
	}

	public List<User> getUser() {
		// TODO Auto-generated method stub
		List<User> list = userRepository.findAll();
		return list;
	}

	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User update(User user, long l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public User updatePartially(User user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public User updatePartially(User user, long id) { // TODO Auto-generated
	 * method stub User usr = findById(id); usr.setCountry(user.getCountry());
	 * return userRepository.save(usr); }
	 */



}
