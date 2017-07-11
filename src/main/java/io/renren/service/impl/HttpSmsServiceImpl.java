package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.HttpSmsDao;
import io.renren.entity.HttpSmsEntity;
import io.renren.service.HttpSmsService;



@Service("httpSmsService")
public class HttpSmsServiceImpl implements HttpSmsService {
	@Autowired
	private HttpSmsDao httpSmsDao;
	
	@Override
	public HttpSmsEntity queryObject(Long id){
		return httpSmsDao.queryObject(id);
	}
	
	@Override
	public List<HttpSmsEntity> queryList(Map<String, Object> map){
		return httpSmsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return httpSmsDao.queryTotal(map);
	}
	
	@Override
	public void save(HttpSmsEntity httpSms){
		httpSmsDao.save(httpSms);
	}
	
	@Override
	public void update(HttpSmsEntity httpSms){
		httpSmsDao.update(httpSms);
	}
	
	@Override
	public void delete(Long id){
		httpSmsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		httpSmsDao.deleteBatch(ids);
	}

	@Override
	public HttpSmsEntity queryObjectByMsgId(String msgId) {
		return httpSmsDao.queryObjectByMsgId(msgId);
	}
	
}
