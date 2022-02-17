package com.xu.service;

import java.util.List;

import com.xu.pojo.EUTreeNode;
import com.xu.pojo.EasyBuyResult;

public interface ContentCatService {
	
	public List<EUTreeNode> getContentCatList(long parentId);
	public EasyBuyResult createContentCat(long parentId,String name);

}
