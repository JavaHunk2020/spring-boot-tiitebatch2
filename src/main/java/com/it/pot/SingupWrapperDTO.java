package com.it.pot;

import java.util.ArrayList;
import java.util.List;

public class SingupWrapperDTO {
	private List<?> signups=new ArrayList<>();
	private String code;
	private String message;

	public List<?> getSignups() {
		return signups;
	}

	public void setSignups(List<?> signupResponse) {
		this.signups = signupResponse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
