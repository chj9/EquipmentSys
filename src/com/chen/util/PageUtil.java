package com.chen.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.chen.model.PageBean;
import com.mysql.jdbc.StringUtils;

/**
 * 分页工具类
 * @author chenhongjie
 *@Tool
 * 2016年11月5日
 */
public class PageUtil {

public static Map<String, Object> getPageAndRow(PageBean pageRows){
			Integer page = 1;
			if(!StringUtils.isNullOrEmpty(pageRows.getPage())){
				page=Integer.valueOf(pageRows.getPage());
			}
			Integer rows = 20;
			if(!StringUtils.isNullOrEmpty(pageRows.getRows())){
				rows=Integer.valueOf(pageRows.getRows());
			}		
			Map<String,Object> paramMap = new HashMap<String,Object>();
			int start =0;
			if (page > -1)start = (page - 1) * rows;
			paramMap.put("start", start);
			paramMap.put("rows", rows);
			return paramMap;
	}
/**
 * easy ui 需要返回的分页数据
 *@2016年11月5日
 *@return
 */
public static <T> JSONObject ListBeanToJSON(List<T> list,Integer total){
	try {
		 JSONObject data = new JSONObject();
		 JSONArray rows = JSONArray.fromObject(list);
		 data.put("rows",rows);
		 data.put("total",total);
		 return data;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

public static <T> JSONArray ListBeantoArray(List<T> list){
	JSONArray rows = JSONArray.fromObject(list);
	
	return rows;
}
}
