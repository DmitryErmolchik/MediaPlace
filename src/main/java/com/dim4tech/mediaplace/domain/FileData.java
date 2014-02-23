package com.dim4tech.mediaplace.domain;

public class FileData {
	String baseName;
	String fullPath;
	
	public FileData(String baseName, String fullPath) {
		super();
		this.baseName = baseName;
		this.fullPath = fullPath;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	
}
