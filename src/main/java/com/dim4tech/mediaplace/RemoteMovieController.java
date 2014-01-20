package com.dim4tech.mediaplace;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;

@Controller
@RequestMapping(value = "/remote")
public class RemoteMovieController {
	private static final Logger logger = LoggerFactory
			.getLogger(RemoteMovieController.class);

	@Autowired
	PlayerContext mplayerContext;

	@RequestMapping(method = RequestMethod.GET)
	public String ShowCommands(Locale locale, Model model) {
		model.addAttribute("listOfCommands",
				mplayerContext.getRemoteCommands().values());
		return "remote";
	}

	@RequestMapping(method = RequestMethod.GET, params = { "command" })
	public String SendCommand(Locale locale, Model model,
			@RequestParam(value = "command") String command) {
		String[] remoteCommand = { "sh", "-c",
				"echo " + command + " > " + mplayerContext.getMplayerFIFOPath() };
		logger.debug("echo \"" + command + "\" > " + mplayerContext.getMplayerFIFOPath());
		try {
			Process playProcess = Runtime.getRuntime().exec(remoteCommand);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		}
		model.addAttribute("listOfCommands",
				mplayerContext.getRemoteCommands().values());
		if (mplayerContext.getRemoteCommands().get(command).isTerminate()) {
			return "redirect:/";
		}
		else {
			return "remote";
		}
	}
}
