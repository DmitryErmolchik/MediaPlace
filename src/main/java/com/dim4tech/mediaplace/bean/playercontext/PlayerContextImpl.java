package com.dim4tech.mediaplace.bean.playercontext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import com.dim4tech.mediaplace.domain.RemoteCommand;

public class PlayerContextImpl implements PlayerContext, ServletContextAware {
	private String mplayerFIFOPath;
	private File videoPath;
	private String[] videoExtensions;
	private Map<String, RemoteCommand> remoteCommands;
	private List<String> playerCommands;
	private Map<String, String> environment;
	private String sudoUser;
	private ServletContext servletContext;
	
	@Override
	public String getMplayerFIFOPath() {
		return mplayerFIFOPath;
	}

	@Override
	public void setMplayerFIFOPath(String mplayerFIFOPath) {
		this.mplayerFIFOPath = mplayerFIFOPath;
	}

	@Override
	public File getVideoPath() {
		return videoPath;
	}

	@Override
	public void setVideoPath(File videoPath) {
			this.videoPath = videoPath;
	}

	@Override
	public String[] getVideoExtensions() {
		return videoExtensions;
	}

	@Override
	public void setVideoExtensions(String[] videoExtensions) {
		this.videoExtensions = videoExtensions;
	}

	@Override
	public Map<String, RemoteCommand> getRemoteCommands() {
		return remoteCommands;
	}

	@Override
	public void setRemoteCommands(Map<String, RemoteCommand> remoteCommands) {
		this.remoteCommands = remoteCommands;
	}

	@Override
	public List<String> getPlayerCommands() {
		return playerCommands;
	}

	@Override
	public void setPlayerCommands(List<String> playerCommands) {
		this.playerCommands = new ArrayList<String>();
		for (String command : this.playerCommands) {
			if (command.indexOf("%fifo%") != -1) {
				this.playerCommands.add(command.replace("%fifo%", mplayerFIFOPath));
			}
			else {
				this.playerCommands.add(command);
			}
		}
	}

	public Map<String, String> getEnvironment() {
		return environment;
	}

	public void setEnvironment(Map<String, String> environment) {
		this.environment = environment;
	}

	public String getSudoUser() {
		return sudoUser;
	}

	public void setSudoUser(String sudoUser) {
		this.sudoUser = sudoUser;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}

	public ServletContext getServletContext() {
		return servletContext;
	}
}
