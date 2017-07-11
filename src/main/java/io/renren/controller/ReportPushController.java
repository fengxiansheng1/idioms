package io.renren.controller;

import io.renren.entity.HttpSmsEntity;
import io.renren.service.HttpSmsService;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 登录相关
 * 
 * @author kevin
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
public class ReportPushController {
	@Autowired
	private HttpSmsService httpSmsService;
	@ResponseBody
	@RequestMapping(value = "/report/push", method = RequestMethod.GET)
	public R login(HttpServletRequest request)throws IOException {
		
		String msgId="";
		 Map<String, String[]> params = request.getParameterMap();  
	        
	        for (String key : params.keySet()) {  
	            String[] values = params.get(key);  
	            for (int i = 0; i < values.length; i++) {
	            	if("msgid".equals(key)){
	            		msgId=values[i];
	            		break;
	            	}
	               
	               
	            }  
	        }  
   
	HttpSmsEntity httpSms = httpSmsService.queryObjectByMsgId(msgId);
	if(null!=httpSms){
		Date pushTime=new Date();
		httpSms.setPushTime(pushTime);
		httpSms.setPrsTime(pushTime.getTime()-httpSms.getResTime().getTime());
		httpSmsService.update(httpSms);	
	}
	
    
		return R.ok();
	}
	
}
