package com.xu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EasyBuyResult;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public EasyBuyResult getContentList(@PathVariable long contentCategoryId){
		System.out.println("来啊");
	
		return contentService.getContentList(contentCategoryId);
	}

}
