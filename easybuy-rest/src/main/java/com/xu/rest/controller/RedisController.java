package com.xu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EasyBuyResult;

@Controller
@RequestMapping("/redis")
public class RedisController {
	@Autowired RedisService redisService;
	@RequestMapping("/content/{categoryId}")
	@ResponseBody
	public EasyBuyResult contentSync(@PathVariable long categoryId){
		
		
		return redisService.contentSync(categoryId);
		
	}

}
