package com.entelgy.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.app.exception.ExceptionResponse;
import com.entelgy.app.model.ResponseWrapper;
import com.entelgy.app.model.Root;
import com.entelgy.app.service.UsersService;


@RestController
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@PostMapping
	public ResponseWrapper reestructurar() throws Exception {

		ResponseWrapper response = new ResponseWrapper();
		
		try {
			Root root = usersService.getObject();
			if (root != null) {
				response.setData(root.getDataString());
				response.setOk(true);				
			} else {
				response.setOk(false);				
			}
			return response;
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " reestructurar. ERROR : " + e.getMessage());
			throw new ExceptionResponse(new Date(), this.getClass().getSimpleName() + "/reestructurar",
					e.getStackTrace()[0].getFileName() + " => " + e.getStackTrace()[0].getMethodName() + " => "
							+ e.getClass() + " => message: " + e.getMessage() + "=> linea nro: "
							+ e.getStackTrace()[0].getLineNumber(), null);
		}
	}

}
