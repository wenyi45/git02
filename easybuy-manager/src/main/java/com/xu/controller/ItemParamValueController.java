package com.xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xu.service.ItemParamValueService;

import javax.annotation.Resource;


@Controller
public class ItemParamValueController {
	@Resource
	ItemParamValueService itemParamValueService;

	@RequestMapping("/showParamValue/{itemId}")
	public String getItemById(@PathVariable Long itemId,Model model){
		String values = itemParamValueService.geTbItemParamValueById(itemId);
		model.addAttribute("itemParam", values);
		
		return "item";
		
	}
}
