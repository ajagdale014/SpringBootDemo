package com.example.springapp.model;

public class RequestWrapperOrder {
	private String name;

	public RequestWrapperOrder(String name) {
		super();
		this.name = name;
	}
	public RequestWrapperOrder() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RequestWrapperOrder [name=" + name + "]";
	}
	
}
