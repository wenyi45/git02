package com.xu.service;

import java.util.List;

import com.xu.pojo.EUTreeNode;

public interface ItemCatService {
	
	public List<EUTreeNode> getItemList(long parentId);

}
