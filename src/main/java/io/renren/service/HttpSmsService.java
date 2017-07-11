package io.renren.service;

import io.renren.entity.HttpSmsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-16 13:25:23
 */
public interface HttpSmsService {
	
	HttpSmsEntity queryObject(Long id);
	

	HttpSmsEntity queryObjectByMsgId(String msgId);
	
	
	
	List<HttpSmsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HttpSmsEntity httpSms);
	
	void update(HttpSmsEntity httpSms);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
