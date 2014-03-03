package com.dim4tech.mediaplace.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class RemoteCommand {
	private String name;
	private boolean terminate;
	private List<String> parameters;
	
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

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
}
