package com.ojas.candidjava.spring.testController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.candidjava.spring.bean.User;
import com.candidjava.spring.controller.UserController;
import com.candidjava.spring.service.UserService;
import com.candidjava.spring.service.UserServiceImp;

public class UserControllerTest1 {
	@InjectMocks
	UserController userController;
	@Mock
	UserService userService;
	@Spy
	User user;

	@Before
	public void init() {
		userController = new UserController();
		userService = Mockito.mock(UserServiceImp.class);
		try {
			setCollaborator(userController, "userService", userService);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setCollaborator(Object object, String name, Object service) throws Exception {
		Field field;
		field = object.getClass().getDeclaredField(name);
		field.setAccessible(true);
		field.set(object, service);
	}

	@Test
	public void testCreate() {
		user = new User();
		user.setId(101);
		user.setName("raghu");
		user.setCountry("ind");
		user.setStatus("ok");
		when(userService.createUser(user)).thenReturn(user);
		ResponseEntity<User> createUser = userController.createUser(user);
		assertEquals(createUser.getStatusCode(), HttpStatus.OK);

	}

	@Test
	public void testSaveNull() {

		User user = new User();

		user.setId(0);
		user.setName(null);
		user.setCountry("ind");
		user.setStatus("ok");

		when(userService.createUser(user)).thenReturn(null);
		ResponseEntity<User> createUser = userController.createUser(user);
		assertEquals(createUser.getStatusCode(), HttpStatus.BAD_REQUEST);

		// assertNull(createUser);

	}

	@Test
	public void testGet() {
		List<User> list = new ArrayList<User>();
		User u = new User();
		list.add(u);
		when(userService.getUser()).thenReturn(list);
		ResponseEntity<List<User>> allUser = userController.getAllUser();
		assertEquals(allUser.getStatusCode(), HttpStatus.OK);

	}

	@Test
	public void testGetNull() {
		List<User> list = new ArrayList<User>();
		User u = new User();
		list.add(u);
		when(userService.getUser()).thenReturn(null);
		ResponseEntity<List<User>> allUser = userController.getAllUser();
		assertEquals(allUser.getStatusCode(), HttpStatus.CONFLICT);
	}

	
	  @Test public void testDelete() {
	  
	  User user = new User(); user.setId(1); user.setName("ajay");
	  user.setCountry("ind"); user.setStatus("ok");
	  
	  when(userService.deleteUserById(user.getId())); ResponseEntity<User>
	  deleteUser = userController.deleteUser(user.getId());
	  assertEquals(deleteUser.getStatusCode(), HttpStatus.NO_CONTENT); }
	  
	  @Test public void testDeleteNull() throws Exception {
	  
	  User user = new User(); user.setId(1); user.setName("ajay");
	  user.setCountry("ind"); user.setStatus("ok");
	  
	  when(userService.deleteUserById(user.getId())).thenReturn(null);
	  ResponseEntity<User> deleteUser = userController.deleteUser(user.getId());
	  assertEquals(deleteUser.getStatusCode(), HttpStatus.NO_CONTENT); }
	 

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1);
		user.setName("ajay");
		user.setCountry("ind");
		user.setStatus("ok");
		when(userService.updatePartially(user, user.getId())).thenReturn(user);
		ResponseEntity<User> updateUserPartially = userController.updateUserPartially(user.getId(), user);
		assertEquals(updateUserPartially.getStatusCode(), HttpStatus.OK);

	}

}
