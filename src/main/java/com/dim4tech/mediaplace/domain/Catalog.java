package com.dim4tech.mediaplace.domain;

import java.util.List;

public class Catalog {
	private String currentPath;
	private List<FileData> directories;
	private List<FileData> files;
	
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
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
}
