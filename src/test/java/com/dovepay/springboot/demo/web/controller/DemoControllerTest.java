package com.dovepay.springboot.demo.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dovepay.springboot.demo.web.SpringbootDemoWebApplication;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！ 
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本
@SpringBootTest(classes=SpringbootDemoWebApplication.class)// 指定spring-boot的启动类 
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class DemoControllerTest {

    private MockMvc mockMvc;  
    
    @Autowired  
    private DemoController demoController;  
    
    @Before  
    public void setUp() throws Exception {  
         mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();  
    }  
      
    @Test  
    public void testDemoGet() throws Exception {  
    	ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/get"));  
    	MvcResult mvcResult = resultActions.andReturn();  
    	String result = mvcResult.getResponse().getContentAsString();  
    	System.out.println("get demo:" + result);  
    } 
    
}
