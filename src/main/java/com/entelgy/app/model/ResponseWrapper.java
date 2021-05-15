package com.entelgy.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper {

	private boolean ok;
	private Object defaultObj;
	private List<? extends Object> data;

	public Object getDefaultObj() {
		return defaultObj;
	}

	public void setDefaultObj(Object defaultObj) {
		this.defaultObj = defaultObj;
	}

	public List<? extends Object> getData() {
		return data;
	}

	public void setData(List<? extends Object> data) {
		this.data = data;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
