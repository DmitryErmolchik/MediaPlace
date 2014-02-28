package com.dim4tech.mediaplace.domain;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

public class Catalog {
	private String currentPath;
	private List<FileData> directories;
	private List<FileData> files;
	private String backLink;
	
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
		if (currentPath.lastIndexOf('/') != -1)
			this.backLink = StringEscapeUtils.escapeEcmaScript(currentPath.substring(0, currentPath.lastIndexOf('/')));
		else
			this.backLink = "";
	}
	public List<FileData> getDirectories() {
		return directories;
	}
	public void setDirectories(List<FileData> directories) {
		this.directories = directories;
	}
	public List<FileData> getFiles() {
		return files;
	}
	public void setFiles(List<FileData> files) {
		this.files = files;
	}
	
	public String getBackLink() {
		return this.backLink;
	}
}
