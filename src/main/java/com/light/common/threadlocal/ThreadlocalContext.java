package com.light.common.threadlocal;

import com.light.common.threadlocal.base.BaseThreadlocalContext;

public class ThreadlocalContext extends BaseThreadlocalContext {
	 
	private Integer userId;
   
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	} 
}
