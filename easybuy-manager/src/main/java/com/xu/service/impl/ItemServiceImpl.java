package com.xu.service.impl;

import java.util.Date;
import java.util.List;

import com.xu.dao.TbItemDescMapper;
import com.xu.dao.TbItemMapper;
import com.xu.dao.TbItemParamValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.pojo.EUDataGridResult;
import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbItem;
import com.xu.pojo.TbItemDesc;
import com.xu.pojo.TbItemExample;
import com.xu.pojo.TbItemParamValue;
import com.xu.service.ItemService;
import com.xu.utils.IDUtils;

import javax.annotation.Resource;

@Service
public class ItemServiceImpl implements ItemService {
	@Resource
	TbItemMapper itemMapper;
	@Resource
	TbItemDescMapper tbItemDescMapper;
	@Resource
	TbItemParamValueMapper tbItemParamValueMapper;
	@Override
	public EUDataGridResult getTbItemList(int page, int rows) {
		TbItemExample example=new TbItemExample();
		example.setOrderByClause("created desc");
		PageHelper.startPage(page, rows);
		List<TbItem> list =itemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EasyBuyResult creatItem(TbItem tbItem,String desc,String itemParams) throws Exception {
		long itemId = IDUtils.genItemId();
		tbItem.setId(itemId);
		tbItem.setStatus((byte) 1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		itemMapper.insert(tbItem);
		EasyBuyResult resultDesc = insertDesc(itemId, desc);
		EasyBuyResult resultParamValue = insertItemParamValue(itemId, itemParams);
		if (resultDesc.getStatus()!=200) {
			throw new Exception("数据繁忙");
		}
		if (resultParamValue.getStatus()!=200) {
			throw new Exception("数据繁忙");
		}
		return EasyBuyResult.ok();
	}
	
	public EasyBuyResult insertDesc(long itemId,String desc){
		TbItemDesc tbItemDesc=new TbItemDesc();
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		tbItemDescMapper.insert(tbItemDesc);
		
		return EasyBuyResult.ok();
		
	}
	public EasyBuyResult insertItemParamValue(long itemId,String itemParams){
		TbItemParamValue paramValue=new TbItemParamValue();
		paramValue.setItemId(itemId);
		paramValue.setParamData(itemParams);
		paramValue.setCreated(new Date());
		paramValue.setUpdated(new Date());
		tbItemParamValueMapper.insert(paramValue);
		
		return EasyBuyResult.ok();
		
	}
	

	/*public List<TbItem> getTbItemList() {
		
		TbItemExample example=new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(example);
		return list;
	}*/
	
	

}
