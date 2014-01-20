package com.dim4tech.mediaplace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dim4tech.mediaplace.bean.RuntimeCommandLogger;
import com.dim4tech.mediaplace.bean.playercontext.PlayerContext;

@Controller
@RequestMapping(value = "/playMovie")
public class PlayMovieController {

	private static final Logger logger = LoggerFactory
			.getLogger(PlayMovieController.class);
	
	@Autowired
	PlayerContext mplayerContext;
	@Autowired
	RuntimeCommandLogger runtimeCommandLogger;
	
	@RequestMapping(method = RequestMethod.GET, params = { "movie" })
	public String playMovie(Locale locale, Model model,
			@RequestParam(value = "movie") String movie) {
		try {
			File mplayerFIFO = new File(mplayerContext.getMplayerFIFOPath());
			if (!mplayerFIFO.exists()) {
				List<String> createFIFO = new ArrayList<String>();
				createFIFO.add("mkfifo");
				createFIFO.add(mplayerContext.getMplayerFIFOPath());
				Runtime.getRuntime().exec(createFIFO.toArray(new String[createFIFO.size()]));
				
				createFIFO = new ArrayList<String>();
				createFIFO.add("chmod");
				createFIFO.add("666");
				createFIFO.add(mplayerContext.getMplayerFIFOPath());
				Runtime.getRuntime().exec(createFIFO.toArray(new String[createFIFO.size()]));
			}
			
			File playMovieScript = new File(mplayerContext.getServletContext().getRealPath("resources") + "/playMovie.sh");
			if (!playMovieScript.canExecute()) {
				List<String> giveRights = new ArrayList<String>();
				giveRights.add("chmod");
				giveRights.add("+x");
				giveRights.add(playMovieScript.getAbsolutePath());
				Runtime.getRuntime().exec(giveRights.toArray(new String[giveRights.size()]));
			}

			List<String> sudoCommand = new ArrayList<String>();
			logger.debug(mplayerContext.getServletContext().getRealPath("resources") + "/playMovie.sh");	
			sudoCommand.add(mplayerContext.getServletContext().getRealPath("resources") + "/playMovie.sh");
			sudoCommand.add(movie);
			
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command(sudoCommand);
			Process playProcess = processBuilder.start();
			
			//runtimeCommandLogger.log(playProcess, logger);

		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
			return "redirect:/";
		}
		return "redirect:remote";
	}
	
	private void writeCommandToStream(OutputStream outputStream, String command) throws IOException {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		outputStreamWriter.write(command);
	}
}
