package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-16 13:25:23
 */
public class HttpSmsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//消息ID
	private String msgId;
	//请求时间
	private Date resTime;
	//响应时间
	private Date respTime;
	//状态报告的推送时间
	private Date pushTime;
	//请求时间和响应时间差值，单位是 毫秒ms
	private Long rrsTime;
	//推送时间和响应时间差值，单位是 毫秒ms
	private Long prsTime;
	//HTTP 状态响应码
	private String status;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：消息ID
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：消息ID
	 */
	public String getMsgId() {
		return msgId;
	}
	/**
	 * 设置：请求时间
	 */
	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}
	/**
	 * 获取：请求时间
	 */
	public Date getResTime() {
		return resTime;
	}
	/**
	 * 设置：响应时间
	 */
	public void setRespTime(Date respTime) {
		this.respTime = respTime;
	}
	/**
	 * 获取：响应时间
	 */
	public Date getRespTime() {
		return respTime;
	}
	/**
	 * 设置：状态报告的推送时间
	 */
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
	/**
	 * 获取：状态报告的推送时间
	 */
	public Date getPushTime() {
		return pushTime;
	}
	/**
	 * 设置：请求时间和响应时间差值，单位是 毫秒ms
	 */
	public void setRrsTime(Long rrsTime) {
		this.rrsTime = rrsTime;
	}
	/**
	 * 获取：请求时间和响应时间差值，单位是 毫秒ms
	 */
	public Long getRrsTime() {
		return rrsTime;
	}
	/**
	 * 设置：推送时间和响应时间差值，单位是 毫秒ms
	 */
	public void setPrsTime(Long prsTime) {
		this.prsTime = prsTime;
	}
	/**
	 * 获取：推送时间和响应时间差值，单位是 毫秒ms
	 */
	public Long getPrsTime() {
		return prsTime;
	}
	/**
	 * 设置：HTTP 状态响应码
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：HTTP 状态响应码
	 */
	public String getStatus() {
		return status;
	}
}
