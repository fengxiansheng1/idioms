package io.renren.dao;

import io.renren.entity.HttpSmsEntity;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-16 13:25:23
 */
public interface HttpSmsDao extends BaseDao<HttpSmsEntity> {

	HttpSmsEntity queryObjectByMsgId(String msgId);
	
}
