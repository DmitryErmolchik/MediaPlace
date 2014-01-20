package com.dim4tech.mediaplace.domain;

import org.springframework.beans.factory.annotation.Required;

public class RemoteCommand {
	private String name;
	private boolean terminate;
	
	public RemoteCommand() {
		terminate = false;
	}
	
	public String getName() {
		return name;
	}
	
	@Required
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isTerminate() {
		return terminate;
	}
	
	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}
}
