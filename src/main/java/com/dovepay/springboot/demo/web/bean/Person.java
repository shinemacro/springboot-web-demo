package com.dovepay.springboot.demo.web.bean;

public class Person {
	private String name;
	private int age;
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "name:"+name+", age:"+age+", id:"+id;
	}
}
