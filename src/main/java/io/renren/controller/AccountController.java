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

import io.renren.entity.AccountEntity;
import io.renren.service.AccountService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-16 11:17:23
 */
@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/account.html")
	public String list(){
		return "account/account.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("account:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<AccountEntity> accountList = accountService.queryList(map);
		int total = accountService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(accountList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("account:info")
	public R info(@PathVariable("id") Long id){
		AccountEntity account = accountService.queryObject(id);
		
		return R.ok().put("account", account);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("account:save")
	public R save(@RequestBody AccountEntity account){
		account.setCreateTime(new Date());
		accountService.save(account);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("account:update")
	public R update(@RequestBody AccountEntity account){
		account.setCreateTime(new Date());
		accountService.update(account);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("account:delete")
	public R delete(@RequestBody Long[] ids){
		accountService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
