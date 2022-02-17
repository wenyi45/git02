package com.xu.service;

import com.xu.pojo.EUDataGridResult;
import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbItem;

public interface ItemService {
	public EUDataGridResult getTbItemList(int page,int rows );
	public EasyBuyResult creatItem(TbItem tbItem, String desc, String itemParams) throws Exception;
}
