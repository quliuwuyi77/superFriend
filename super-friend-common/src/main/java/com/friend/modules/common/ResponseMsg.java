package com.friend.modules.common;


import java.io.Serializable;

public class ResponseMsg<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	//@ApiModelProperty("header,通用header对象")
	Header header = new Header();

	//@ApiModelProperty("responseBody,自定义返回对象")
	private T responseBody;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	public T getResponseBody() {
		return responseBody;
	}
	
	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}


	public void setRetCode(String retCode) {
		header.retCode = retCode;
	}

	public void setErrorDesc(String errorDesc) {
		header.errorDesc = errorDesc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Header [retCode=");
		builder.append(header.getRetCode());
		builder.append(", errorDesc=");
		builder.append(header.getErrorDesc());
		builder.append("]");
		builder.append("   Body [");
		if(responseBody!=null) {
			builder.append(responseBody.toString());
		}
		builder.append("]");
		return builder.toString();
	}


}
