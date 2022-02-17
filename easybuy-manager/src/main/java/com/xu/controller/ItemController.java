package com.xu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.xu.pojo.EUDataGridResult;
import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbItem;
import com.xu.service.ItemService;

import javax.annotation.Resource;

@Controller
public class ItemController {
	@Resource
	ItemService itemService;

/*	@RequestMapping("/item/list")
	public List<TbItem> getTbItemList(){
		List<TbItem> list = itemService.getTbItemList();
		
		return list;
	}*/
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getTbItemList(Integer page,Integer rows ){
		EUDataGridResult itemList = itemService.getTbItemList(page, rows);
		return itemList;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public EasyBuyResult creatItem(TbItem tbItem,String desc,String itemParams) throws Exception{
		return itemService.creatItem(tbItem,desc,itemParams);
	}
}
