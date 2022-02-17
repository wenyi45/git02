package com.xu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EUTreeNode;
import com.xu.pojo.EasyBuyResult;
import com.xu.service.ContentCatService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/content/category")
public class ContentCatController {
	@Resource
	ContentCatService contentCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		return contentCatService.getContentCatList(parentId);
		
	}
	@RequestMapping("/create")
	@ResponseBody
	public EasyBuyResult createContentCat(long parentId,String name){
		return contentCatService.createContentCat(parentId, name);
	}

}
