package io.renren.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import io.renren.entity.HttpSmsEntity;
import io.renren.service.HttpSmsService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-16 13:25:23
 */
@Controller
@RequestMapping("httpsms")
public class HttpSmsController {
	@Autowired
	private HttpSmsService httpSmsService;
	
	@RequestMapping("/httpsms.html")
	public String list(){
		return "httpsms/httpsms.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("httpsms:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<HttpSmsEntity> httpSmsList = httpSmsService.queryList(map);
		int total = httpSmsService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(httpSmsList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	

	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("httpsms:info")
	public R info(@PathVariable("id") Long id){
		HttpSmsEntity httpSms = httpSmsService.queryObject(id);
		
		return R.ok().put("httpSms", httpSms);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("httpsms:save")
	public R save(@RequestBody HttpSmsEntity httpSms){
		httpSmsService.save(httpSms);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("httpsms:update")
	public R update(@RequestBody HttpSmsEntity httpSms){
		httpSmsService.update(httpSms);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("httpsms:delete")
	public R delete(@RequestBody Long[] ids){
		httpSmsService.deleteBatch(ids);
		
		return R.ok();
	}
	
	
	
	
}
