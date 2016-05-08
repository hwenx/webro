package org.jbros.webro.common.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Response {
	
	@JsonProperty("stat")
	@JsonInclude(Include.NON_NULL)
	private String stat;
	
	@JsonProperty("code")
	@JsonInclude(Include.NON_NULL)
	private String code;
	
	@JsonProperty("data")
	@JsonInclude(Include.NON_NULL)
	public Object data;

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
