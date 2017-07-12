package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.SysIdiomsDao;
import io.renren.entity.SysIdiomsEntity;
import io.renren.service.SysIdiomsService;



@Service("sysIdiomsService")
public class SysIdiomsServiceImpl implements SysIdiomsService {
	@Autowired
	private SysIdiomsDao sysIdiomsDao;
	
	@Override
	public SysIdiomsEntity queryObject(Long idiomsId){
		return sysIdiomsDao.queryObject(idiomsId);
	}
	
	@Override
	public List<SysIdiomsEntity> queryList(Map<String, Object> map){
		return sysIdiomsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysIdiomsDao.queryTotal(map);
	}
	
	@Override
	public void save(SysIdiomsEntity sysIdioms){
		sysIdiomsDao.save(sysIdioms);
	}
	
	@Override
	public void update(SysIdiomsEntity sysIdioms){
		sysIdiomsDao.update(sysIdioms);
	}
	
	@Override
	public void delete(Long idiomsId){
		sysIdiomsDao.delete(idiomsId);
	}
	
	@Override
	public void deleteBatch(Long[] idiomsIds){
		sysIdiomsDao.deleteBatch(idiomsIds);
	}
	
}
