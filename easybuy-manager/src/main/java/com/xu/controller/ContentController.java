package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbContent;
import com.xu.service.ContentService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Resource
	ContentService contentService;
	
	
	@RequestMapping("/save")
	@ResponseBody
	public EasyBuyResult saveContent(TbContent tbContent){
		
		return contentService.saveContent(tbContent);
		
	}
	

}
