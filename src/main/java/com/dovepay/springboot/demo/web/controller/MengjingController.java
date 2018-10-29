package com.dovepay.springboot.demo.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dovepay.springboot.demo.web.bean.Person;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/mengjing")
@Api(value = "mengjing", description = "mengjing管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class MengjingController {
	
    @RequestMapping(value="/getMap")
    public Map<String,Object> getMap(){
    	Map<String,Object> a = new HashMap<String,Object>();
    	String name = "mengjing";
    	int age = 30;
    	a.put("myname", name);
    	a.put("myage", age);
    	return a;
    }
    
    @RequestMapping(value="/getList")
    public static List<String> getList(){
	    List<String> b = new ArrayList<String>();
	    String face = "beautiful";
	    int period = 100;
	    b.add("mengjing");
	    b.add(face);
	    b.add(String.valueOf(period));
	    return b;
    }
    
    @RequestMapping(value="/getPerson")
    public static Person getPerson() {
    	Person a = new Person();
    	a.setName("mengjing");
    	a.setAge(30);
    	a.setId("001");
    	return a;
    }
    
    public static void main(String[] args) {
    	System.out.println(new MengjingController().getMap());
    	System.out.println(new MengjingController().getList());
    	System.out.println(MengjingController.getList());
    	System.out.println(MengjingController.getPerson());
    	System.out.println(MengjingController.getPerson().toString());
    }
}
