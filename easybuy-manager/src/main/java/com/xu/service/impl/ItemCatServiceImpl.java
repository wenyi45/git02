package com.xu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xu.dao.TbItemCatMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.EUTreeNode;
import com.xu.pojo.TbItemCat;
import com.xu.pojo.TbItemCatExample;
import com.xu.pojo.TbItemCatExample.Criteria;
import com.xu.service.ItemCatService;

import javax.annotation.Resource;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Resource
	TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EUTreeNode> getItemList(long parentId) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList=new ArrayList<>();
		for (TbItemCat cat : list) {
			EUTreeNode node=new EUTreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		
		return resultList;
	}

}
