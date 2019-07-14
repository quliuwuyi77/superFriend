package com.friend.modules.common;

import java.io.Serializable;

public class Header implements Serializable{
	private static final long serialVersionUID = 2758167744976216931L;

	//@ApiModelProperty("retCode,200成功，其它为失败")
	String retCode = ResponseStatus.HTTP_OK;
	
	//@ApiModelProperty("errorDesc,错误描述信息")
	String errorDesc = null;
	
	
	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

}
