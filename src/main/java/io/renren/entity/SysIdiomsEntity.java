package io.renren.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-12 20:51:32
 */
public class SysIdiomsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long idiomsId;
	//成语的名称
	private String name;
	//成语的解释意思
	private String description;
	//4:四字成语，5，6，……11字成语
	private Integer type;
	//0:未删除，1：已经删除
	private Integer isDeleted;
	//
	private Long createUserId;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setIdiomsId(Long idiomsId) {
		this.idiomsId = idiomsId;
	}
	/**
	 * 获取：
	 */
	public Long getIdiomsId() {
		return idiomsId;
	}
	/**
	 * 设置：成语的名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：成语的名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：成语的解释意思
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：成语的解释意思
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：4:四字成语，5，6，……11字成语
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：4:四字成语，5，6，……11字成语
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：0:未删除，1：已经删除
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：0:未删除，1：已经删除
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
