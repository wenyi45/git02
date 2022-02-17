package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EasyBuyResult;
import com.xu.service.ItemParamKeyService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/item/param")
public class ItemParamKeyController {
	@Resource
	ItemParamKeyService itemParamKeyService;
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public EasyBuyResult getItemParamKeyById(@PathVariable long itemCatId){
		
		
		return itemParamKeyService.getItemParamKeyById(itemCatId);
		
	}
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public EasyBuyResult saveItemParamKey(@PathVariable long cid,String paramData){
		
		
		return itemParamKeyService.saveItemParamKey(cid, paramData);
		
	}
	

}
