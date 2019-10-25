package com.ojas.candidjava.spring.testService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.repository.UserRepository;
import com.candidjava.spring.service.UserService;
import com.candidjava.spring.service.UserServiceImp;

public class TestUserService {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Spy
	User user;
	
	
	@Before
	public void inti() throws Exception {
		userService=new UserServiceImp();
		userRepository  = Mockito.mock(UserRepository.class);
		setCollaborator(userService, "userRepository", userRepository);
	}
	
	
	public void setCollaborator(Object object, String name, Object service) throws Exception {
		Field field;
		field = object.getClass().getDeclaredField(name);
		field.setAccessible(true);
		field.set(object, service);
	}
	@Test
	public void testSave() {

		User user=new User();
		
		when(userRepository.save(user)).thenReturn(user);
		              User createUser = userService.createUser(user);
		assertEquals(user.getName(),user.getCountry(),createUser.getStatus() );
		
		
	}
	

}
