package com.dim4tech.mediaplace;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;
import com.dim4tech.mediaplace.domain.RemoteCommand;

@Controller
@RequestMapping(value = "/remote")
public class RemoteMovieController {
	private static final Logger logger = LoggerFactory
			.getLogger(RemoteMovieController.class);

	@Autowired
	PlayerContext mplayerContext;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Map<String, RemoteCommand> ShowCommands(Locale locale, Model model) {
		return mplayerContext.getRemoteCommands();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "command" })
	public void SendCommand(Locale locale, Model model,
			@RequestParam(value = "command") String command) {
		String[] remoteCommand = { "sh", "-c",
				"echo " + command + " > " + mplayerContext.getMplayerFIFOPath() };
		logger.debug("echo \"" + command + "\" > " + mplayerContext.getMplayerFIFOPath());
		try {
			Process playProcess = Runtime.getRuntime().exec(remoteCommand);
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		}
	}
}
