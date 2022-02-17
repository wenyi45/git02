package com.xu.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xu.dao.TbItemCatMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.TbItemCat;
import com.xu.pojo.TbItemCatExample;
import com.xu.pojo.TbItemCatExample.Criteria;
import com.xu.rest.pojo.CatNode;
import com.xu.rest.pojo.CatResult;
import com.xu.rest.service.ItemCatService;

import javax.annotation.Resource;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Resource
	TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCat() {
		CatResult result=new CatResult();
		result.setData(getCatNode(0));
		
		return result;
	}
	
	public List<CatNode> getCatNode(long parentId) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List resultList=new ArrayList<>();
		int count=0;
		
		for (TbItemCat tbItemCat : list) {
			if(count==14){
				break;
			}
			CatNode node=new CatNode();
			if (tbItemCat.getIsParent()) {
				if (parentId==0) {
					node.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
	
				}else{
					node.setName(tbItemCat.getName());
				}
				node.setUrl("/products/"+tbItemCat.getId()+".html");
				node.setItem(getCatNode(tbItemCat.getId()));
				resultList.add(node);
			}else{
				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName()+"");
			}
			count++;
		}
		return resultList;
		
		
	}



}
