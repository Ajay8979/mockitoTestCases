package com.ojas.candidjava.spring.testController;

import static org.hamcrest.CoreMatchers.any;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.controller.UserController;
import com.candidjava.spring.repository.UserRepository;
import com.candidjava.spring.service.UserService;
import com.candidjava.spring.service.UserServiceImp;

public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Before
	public void init() throws Exception {
		userController = new UserController();
		userService = mock(UserServiceImp.class);
		setCollaborator(userController, "userService", userService);
	}

	public void setCollaborator(Object object, String name, Object service) throws Exception {
		Field field;
		field = object.getClass().getDeclaredField(name);
		field.setAccessible(true);
		field.set(object, service);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setCountry("ind");
		user.setId(101);
		user.setName("ajay");

		User user2 = new User(); // user.setS tatus("ok");

		when(userService.createUser(any())).thenReturn(user);
		ResponseEntity<User> createUser = userController.createUser(user);
		assertEquals(createUser.getStatusCode(), HttpStatus.OK);

	}

	

	

}
