package com.entelgy.app.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.*;
import com.entelgy.app.model.Root;
import com.entelgy.app.model.Users;
import com.entelgy.app.service.UsersService;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
public class UsersServiceImplTest extends MockHttpSession{

	@InjectMocks
	UsersServiceImpl userService;
	
	@Mock
	RestTemplate restTemplate;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetObject() {
		
		ReflectionTestUtils.setField(userService, "urlGet", "https://reqres.in/api/users");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<Root> requestEntity = new HttpEntity<Root>(null, requestHeaders);
		
		 Root root = new Root();
		 root.setData(getUsers());
	        //define the entity you want the exchange to return
	        ResponseEntity<Root> myEntity = new ResponseEntity<Root>(root, HttpStatus.ACCEPTED);
	        Mockito.when(restTemplate.exchange(
	            Matchers.eq("https://reqres.in/api/users"),
	            Matchers.eq(HttpMethod.GET),
	            eq(requestEntity),
	            eq(Root.class))
	        ).thenReturn(myEntity);

	        Root res = userService.getObject();
	        assertTrue(res != null);
	}
	
	@Test
	public void testGetObjectList() {
		
		ReflectionTestUtils.setField(userService, "urlGet", "https://reqres.in/api/users");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<Root> requestEntity = new HttpEntity<Root>(null, requestHeaders);
		
		 Root root = new Root();
		 root.setData(getUsers());
	        //define the entity you want the exchange to return
	        ResponseEntity<Root> myEntity = new ResponseEntity<Root>(root, HttpStatus.ACCEPTED);
	        Mockito.when(restTemplate.exchange(
	            Matchers.eq("https://reqres.in/api/users"),
	            Matchers.eq(HttpMethod.GET),
	            eq(requestEntity),
	            eq(Root.class))
	        ).thenReturn(myEntity);

	        Root res = userService.getObject();
	        assertTrue(res.getDataString().size() > 0);
	}
	
	private List<Users> getUsers(){
		List<Users> lsUsers = new ArrayList<>();
		lsUsers.add(new Users(1,"Torres Morales", "Adriantorresm1997@gmail.com"));
		return lsUsers;
	}

}
