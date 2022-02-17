package com.xu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.rest.pojo.CatResult;
import com.xu.rest.service.ItemCatService;
import com.xu.utils.JsonUtils;



@Controller
public class ItemCatController {
	@Autowired ItemCatService itemCatService;
	
	@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
	 CatResult itemCat = itemCatService.getItemCat();
	 String jsonData = JsonUtils.objectToJson(itemCat);
	 String perfectData=callback+"("+jsonData+");";
		return perfectData;
	}
	
//	@RequestMapping(value="/itemcat/list")
//	@ResponseBody
//	public Object getItemCatList(String callback){
//		CatResult itemCat = itemCatService.getItemCat();
//		MappingJacksonValue jacksonValue = new MappingJacksonValue(itemCat);
//		jacksonValue.setJsonpFunction(callback);
//		return jacksonValue;
//	}

}
