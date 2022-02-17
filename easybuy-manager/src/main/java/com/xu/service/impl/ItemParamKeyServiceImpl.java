package com.xu.service.impl;

import java.util.Date;
import java.util.List;

import com.xu.dao.TbItemParamKeyMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbItemParamKey;
import com.xu.pojo.TbItemParamKeyExample;
import com.xu.pojo.TbItemParamKeyExample.Criteria;
import com.xu.service.ItemParamKeyService;

import javax.annotation.Resource;

@Service
public class ItemParamKeyServiceImpl implements ItemParamKeyService {
	@Resource
	TbItemParamKeyMapper itemParamKeyMapper;


	@Override
	public EasyBuyResult getItemParamKeyById(long itemCatId) {
		TbItemParamKeyExample  example=new TbItemParamKeyExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(itemCatId);
		List<TbItemParamKey> list = itemParamKeyMapper.selectByExampleWithBLOBs(example);
		
		if (list!=null&&list.size()>0) {
			return EasyBuyResult.ok(list.get(0));
			
		}
		
		return EasyBuyResult.ok();
	}


	@Override
	public EasyBuyResult saveItemParamKey(long cid, String paramData) {
		TbItemParamKey paramKey=new TbItemParamKey();
		paramKey.setItemCatId(cid);
		paramKey.setParamData(paramData);
		paramKey.setCreated(new Date());
		paramKey.setUpdated(new Date());
		itemParamKeyMapper.insert(paramKey);
		
	
		return EasyBuyResult.ok();
	}

}
