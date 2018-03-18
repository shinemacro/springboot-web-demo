package com.dovepay.springboot.demo.web.controller;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dovepay.springboot.demo.web.bean.Demo;
import com.dovepay.springboot.demo.web.bean.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/demo")
@Api(value = "demo", description = "demo管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {
    
	// 创建线程安全的Map
	static Map<Integer, Demo> demos = Collections.synchronizedMap(new HashMap<Integer, Demo>());
		
	@RequestMapping
    public String index(){
        return "Hello World!";
    }
    
    @RequestMapping(value="/get")
    public Map<String,Object> getMap(){
        Map<String,Object> demo = new HashMap<String,Object>();
        demo.put("id", 0);
        demo.put("name", "demo");
        demo.put("description", "springboot demo");
        demo.put("version", "0.0.2");
        demo.put("createTime", new Date());
        return demo;
    }
    
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@ApiOperation(value="获取demo详细信息", notes="根据url的id来获取demo详细信息")
	@ApiImplicitParam(name = "id", value = "demo ID", required = true, dataType = "Integer", paramType = "path")
	@RequestMapping(value = "demo/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getDemoById (@PathVariable(value = "id") Integer id){
		JsonResult r = new JsonResult();
		try {
			Demo demo = demos.get(id);
			r.setResult(demo);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
}
