package com.xu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xu.dao.TbContentCategoryMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.EUTreeNode;
import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbContentCategory;
import com.xu.pojo.TbContentCategoryExample;
import com.xu.pojo.TbContentCategoryExample.Criteria;
import com.xu.service.ContentCatService;

import javax.annotation.Resource;

@Service
public class ContentCatServiceImpl implements ContentCatService {
	@Resource
	TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<EUTreeNode> getContentCatList(long parentId) {
		TbContentCategoryExample example=new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		List<EUTreeNode> results=new ArrayList<>();
		for (TbContentCategory cCategory : list) {
			EUTreeNode node=new EUTreeNode();
			node.setId(cCategory.getId());
			node.setText(cCategory.getName());
			node.setState(cCategory.getIsParent()?"closed":"open");
			results.add(node);
		}
		return results;
		
		
	}

	@Override
	public EasyBuyResult createContentCat(long parentId, String name) {
		TbContentCategory currentNode=new TbContentCategory();
		currentNode.setName(name);
		currentNode.setParentId(parentId);
		//状态。可选值:1(正常),2(删除)
		currentNode.setStatus(1);
		currentNode.setSortOrder(1);
		//1为true，0为false
		currentNode.setIsParent(false);
		currentNode.setCreated(new Date());
		currentNode.setUpdated(new Date());
		tbContentCategoryMapper.insert(currentNode);
		TbContentCategory parentNode = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		if (parentNode!=null&&!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			tbContentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		return EasyBuyResult.ok(currentNode);
		
		
	}

}
