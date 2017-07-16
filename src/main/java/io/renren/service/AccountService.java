package io.renren.service;

import io.renren.entity.AccountEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-16 11:17:23
 */
public interface AccountService {
	
	AccountEntity queryObject(Long id);
	
	List<AccountEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AccountEntity account);
	
	void update(AccountEntity account);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
