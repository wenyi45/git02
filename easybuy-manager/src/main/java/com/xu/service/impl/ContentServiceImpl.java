package com.xu.service.impl;

import java.util.Date;

import com.xu.dao.TbContentMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.EasyBuyResult;
import com.xu.pojo.TbContent;
import com.xu.service.ContentService;

import javax.annotation.Resource;

@Service
public class ContentServiceImpl implements ContentService {
	@Resource
	TbContentMapper tbContentMapper;

	@Override
	public EasyBuyResult saveContent(TbContent tbContent) {
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		tbContentMapper.insert(tbContent);
		
		return EasyBuyResult.ok();
	}

}
