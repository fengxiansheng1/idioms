package io.renren.service;

import io.renren.entity.SysIdiomsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-12 20:51:32
 */
public interface SysIdiomsService {
	
	SysIdiomsEntity queryObject(Long idiomsId);
	
	List<SysIdiomsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysIdiomsEntity sysIdioms);
	
	void update(SysIdiomsEntity sysIdioms);
	
	void delete(Long idiomsId);
	
	void deleteBatch(Long[] idiomsIds);
}
