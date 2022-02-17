package com.xu.service.impl;

import java.util.List;
import java.util.Map;

import com.xu.dao.TbItemParamValueMapper;
import org.springframework.stereotype.Service;

import com.xu.pojo.TbItemParamValue;
import com.xu.pojo.TbItemParamValueExample;
import com.xu.pojo.TbItemParamValueExample.Criteria;
import com.xu.service.ItemParamValueService;
import com.xu.utils.JsonUtils;

import javax.annotation.Resource;

@Service
public class ItemParamValueServiceImpl implements ItemParamValueService {
	@Resource
	TbItemParamValueMapper itemParamValueMapper;

	@Override
	public String geTbItemParamValueById(long itemId) {
		TbItemParamValueExample example = new TbItemParamValueExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamValue> list = itemParamValueMapper.selectByExampleWithBLOBs(example);
		if (list == null || list.size() ==0) {
			return "";
		}
		TbItemParamValue paramValue = list.get(0);
		String paramData = paramValue.getParamData();
		List<Map> maps = JsonUtils.jsonToList(paramData, Map.class);
		StringBuilder sb = new StringBuilder();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for (Map m1 : maps) {
			sb.append("        <tr>\n");
			sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
			sb.append("        </tr>\n");
			List<Map> list2 = (List<Map>) m1.get("params");
			for (Map m2 : list2) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
				sb.append("            <td>" + m2.get("v") + "</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();

	}

}
