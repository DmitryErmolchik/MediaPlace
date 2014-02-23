package com.dim4tech.mediaplace;

import java.io.File;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;

@Controller
public class MainViewController {

	private static final Logger logger = LoggerFactory
			.getLogger(MainViewController.class);
	
	@Autowired
	PlayerContext mplayerContext;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		List<File> listOfMediaFile = (List<File>) FileUtils.listFiles(new File(mplayerContext.getVideoPath().getAbsolutePath()), mplayerContext.getVideoExtensions()/*fileFilter*/, true);
		Collections.sort(listOfMediaFile);
		model.addAttribute("listOfMediaFile", listOfMediaFile);
		model.addAttribute("playMovieScriptPath", mplayerContext.getServletContext().getRealPath("resources") + "/playMovie.sh");
		
		return "home";
	}
}
