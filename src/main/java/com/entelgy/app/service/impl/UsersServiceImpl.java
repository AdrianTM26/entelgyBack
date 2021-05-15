package com.entelgy.app.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.app.model.Root;
import com.entelgy.app.model.Users;
import com.entelgy.app.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Value("${entelgy.app.url}")
	public String urlGet;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public Root getObject() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		requestHeaders.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<Root> requestEntity = new HttpEntity<Root>(null, requestHeaders);
		Root root = restTemplate.exchange(urlGet, HttpMethod.GET, requestEntity, Root.class).getBody();
		if (root.getData() != null) {
			List<String> listaString = new ArrayList<>();
			for (Users user : root.getData()) {
				listaString.add(user.getId() + "|" + user.getLast_name() + "|" + user.getEmail());
			}
			root.setData(null);
			root.setDataString(listaString);
		}
		return root;
	}

}
