package com.entelgy.app.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.entelgy.app.model.ResponseWrapper;

@SpringBootTest
@AutoConfigureMockMvc
class UsersControllerTest {

	@Autowired
	UsersController controller;

	@Test
	void testReestructurar() throws Exception {
		ResponseWrapper resp = controller.reestructurar();
		assertTrue(resp.isOk());
	}

	@Test
	void testReestructurarLength() throws Exception {
		ResponseWrapper resp = controller.reestructurar();
		assertTrue(resp.getData().size() > 0);
	}

}
