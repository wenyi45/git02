package com.xu.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.xu.pojo.EasyBuyResult;

public interface ItemParamKeyService {
	public EasyBuyResult getItemParamKeyById(long itemCatId);
	public EasyBuyResult saveItemParamKey(long cid,String paramData);

}
