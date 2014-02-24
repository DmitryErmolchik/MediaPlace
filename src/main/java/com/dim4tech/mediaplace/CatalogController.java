package com.dim4tech.mediaplace;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;
import com.dim4tech.mediaplace.domain.Catalog;
import com.dim4tech.mediaplace.domain.FileData;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
	private static final Logger logger = LoggerFactory
			.getLogger(CatalogController.class);
	
	@Autowired
	PlayerContext mplayerContext;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Catalog getCatalogInJSON() {
		Catalog catalog = new Catalog();
		catalog.setCurrentPath("");

		List<FileData> directories = new ArrayList<FileData>();
		List<File> directoryList = getDirectories(mplayerContext.getVideoPath());
		Collections.sort(directoryList);
		for (File d : directoryList) {
			directories.add(new FileData(d.getName(), d.getAbsolutePath().replace(mplayerContext.getVideoPath().getAbsolutePath() + "/", "")));
		}
		catalog.setDirectories(directories);
		
		List<FileData> files = new ArrayList<FileData>();
		List<File> fileList = getFiles(mplayerContext.getVideoPath());
		Collections.sort(fileList);
		for (File f : fileList) {
			files.add(new FileData(f.getName(), f.getAbsolutePath().replace(mplayerContext.getVideoPath().getAbsolutePath() + "/", "")));
		}
		catalog.setFiles(files);
		
		logger.debug("getCatalogInJSON was run");
		
		return catalog;
	}	
	
	@RequestMapping(method = RequestMethod.GET, params = { "path" })
	public @ResponseBody Catalog getCatalogInJSON(@RequestParam String path) {
		Catalog catalog = new Catalog();
		catalog.setCurrentPath(path);

		List<FileData> directories = new ArrayList<FileData>();
		List<File> directoryList = getDirectories(new File(mplayerContext.getVideoPath().getAbsoluteFile() + "/" + path));
		Collections.sort(directoryList);
		for (File d : directoryList) {
			directories.add(new FileData(d.getName(), d.getAbsolutePath().replace(mplayerContext.getVideoPath().getAbsolutePath() + "/", "")));
		}
		catalog.setDirectories(directories);
		
		List<FileData> files = new ArrayList<FileData>();
		List<File> fileList = getFiles(new File(mplayerContext.getVideoPath().getAbsoluteFile() + "/" + path));
		Collections.sort(fileList);
		for (File f : fileList) {
			files.add(new FileData(f.getName(), f.getAbsolutePath().replace(mplayerContext.getVideoPath().getAbsolutePath() + "/", "")));
		}
		catalog.setFiles(files);
		
		logger.debug("getCatalogInJSON was run");
		
		return catalog;
	}
	
	private List<File> getDirectories(File dir) {
		List<File> directoriesList = new ArrayList<File>();
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				directoriesList.add(f);
			}
		}
		return directoriesList;
	}
	
	private List<File> getFiles(File dir) {
		List<File> filesList = new ArrayList<File>();
		for (File f : dir.listFiles()) {
			if (f.isFile()) {
				filesList.add(f);
			}
		}
		return filesList;
	}
}
