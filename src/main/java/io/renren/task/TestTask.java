package io.renren.task;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.renren.entity.SysIdiomsEntity;
import io.renren.entity.SysUserEntity;
import io.renren.service.SysIdiomsService;
import io.renren.service.SysUserService;
import io.renren.utils.FileReadTxt;

/**
 * 测试定时任务(演示Demo，可删除)
 * 
 * testTask为spring bean的名称
 * 
 * @author kevin
 * @email sunlightcs@gmail.com
 * @date 2016年11月30日 下午1:34:24
 */
@Component("testTask")
public class TestTask {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SysUserService sysUserService;
@Autowired
private SysIdiomsService sysIdiomsService;
	
	public void test(String params){
		logger.info("我是带参数的test方法，正在被执行，参数为：" + params);
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		SysUserEntity user = sysUserService.queryObject(1L);
		System.out.println(ToStringBuilder.reflectionToString(user));
		
	}
	
	
	public void test2() throws IOException{
		logger.info("我是不带参数的test2方法，正在被执行");
		
		final String srcPath = "D:\\account\\idioms\\";
		Map<String,String> map=FileReadTxt.readTxt(srcPath);
		long start=System.currentTimeMillis();
		System.out.println("map size = "+map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {  
			  
		    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			SysIdiomsEntity sysIdioms=new SysIdiomsEntity();
			String drt=entry.getKey();
			
			sysIdioms.setName(drt);
			sysIdioms.setDescription(drt);
			sysIdioms.setIsDeleted(0);
			sysIdioms.setCreateTime(new Date());
			sysIdioms.setType(drt.length());
			sysIdiomsService.save(sysIdioms);
		  
		}
		long end=System.currentTimeMillis();
		System.out.println("cost time  is  :　"+(end-start));
				
		
	}
}
