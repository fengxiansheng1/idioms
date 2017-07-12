package io.renren.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.renren.entity.SysIdiomsEntity;
import io.renren.service.SysIdiomsService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-12 20:51:32
 */
@Controller
@RequestMapping("sysidioms")
public class SysIdiomsController {
	@Autowired
	private SysIdiomsService sysIdiomsService;
	
	@RequestMapping("/sysidioms.html")
	public String list(){
		return "sysidioms/sysidioms.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("sysidioms:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<SysIdiomsEntity> sysIdiomsList = sysIdiomsService.queryList(map);
		int total = sysIdiomsService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(sysIdiomsList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{idiomsId}")
	@RequiresPermissions("sysidioms:info")
	public R info(@PathVariable("idiomsId") Long idiomsId){
		SysIdiomsEntity sysIdioms = sysIdiomsService.queryObject(idiomsId);
		
		return R.ok().put("sysIdioms", sysIdioms);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("sysidioms:save")
	public R save(@RequestBody SysIdiomsEntity sysIdioms){
		sysIdioms.setIsDeleted(0);
		sysIdioms.setCreateTime(new Date());
		sysIdiomsService.save(sysIdioms);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sysidioms:update")
	public R update(@RequestBody SysIdiomsEntity sysIdioms){
		
		sysIdiomsService.update(sysIdioms);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("sysidioms:delete")
	public R delete(@RequestBody Long[] idiomsIds){
		sysIdiomsService.deleteBatch(idiomsIds);
		
		return R.ok();
	}
	
}
