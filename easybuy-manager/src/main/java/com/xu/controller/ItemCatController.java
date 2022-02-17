package com.xu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.pojo.EUTreeNode;
import com.xu.service.ItemCatService;

import javax.annotation.Resource;

@Controller
public class ItemCatController {
	@Resource
	ItemCatService itemCatService;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EUTreeNode> itemCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		System.out.println("进来了！");
		return itemCatService.getItemList(parentId);
	}

}
