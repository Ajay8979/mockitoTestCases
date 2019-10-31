package com.candidjava.spring.bean;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 1L;
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "Status [status=" + status + "]";
}

}
