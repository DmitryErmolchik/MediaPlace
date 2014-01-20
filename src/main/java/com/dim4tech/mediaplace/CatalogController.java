package com.dim4tech.mediaplace;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {
	private static final Logger logger = LoggerFactory
			.getLogger(CatalogController.class);
	
	@Autowired
	PlayerContext mplayerContext;
	
	@RequestMapping(method = RequestMethod.GET)
	public String categories(Locale locale, Model model) {
		File rootDir = new File(mplayerContext.getVideoPath());
		
		List<String> categoriesList = new ArrayList<String>();
		for (File f : rootDir.listFiles()) {
			if (f.isDirectory()) {
				categoriesList.add(f.getPath().replace(mplayerContext.getVideoPath(), "").replaceAll("^/", ""));
			}
		}
		Collections.sort(categoriesList);
		model.addAttribute("categoriesList", categoriesList);
		return "catalog";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{category}/")
	public ModelAndView explore(Locale locale, ModelAndView modelAndView, @PathVariable("category") String category) {
		return getFilledCatalog(modelAndView, category, mplayerContext.getVideoPath() + category + '/');
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{category}", params = { "pathToExplore" })
	public ModelAndView explore(Locale locale, ModelAndView modelAndView, 
			@PathVariable("category") String category,
			@RequestParam("pathToExplore") String pathToExplore) {
		return getFilledCatalog(modelAndView, category, pathToExplore + '/');
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
	
	private ModelAndView getFilledCatalog(ModelAndView modelAndView, String category, String path) {
		modelAndView.setViewName("catalog");
		modelAndView.addObject("category", category);
		
		File dirToExplore = new File(path);
		List<File> directoriesList = getDirectories(dirToExplore);
		List<File> filesList = getFiles(dirToExplore);

		Collections.sort(directoriesList);
		Collections.sort(filesList);
		modelAndView.addObject("directoriesList", directoriesList);
		modelAndView.addObject("filesList", filesList);
		return modelAndView;
	}
}
