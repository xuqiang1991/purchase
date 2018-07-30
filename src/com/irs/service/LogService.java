package com.irs.service;
import java.util.Date;

import com.irs.pojo.admin.TbLog;
import com.irs.util.ResultUtil;
import com.irs.vo.admin.UserSearch;

public interface LogService {
	//添加日志
	public void insLog(TbLog log);
	
	//获取日志列表
	ResultUtil selLogList(Integer page, Integer limit,UserSearch search);

	//删除指定日期以前的日志
	public int delLogsByDate(Date date);
}
