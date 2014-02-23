package com.dim4tech.mediaplace.bean.playercontext;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.dim4tech.mediaplace.domain.RemoteCommand;

public interface PlayerContext{
	public String getMplayerFIFOPath();
	public void setMplayerFIFOPath(String mplayerFIFOPath);
	public File getVideoPath();
	public void setVideoPath(File videoPath);
	public String[] getVideoExtensions();
	public void setVideoExtensions(String[] videoExtensions);
	public Map<String, RemoteCommand> getRemoteCommands();
	public void setRemoteCommands(Map<String, RemoteCommand> remoteCommands);
	public List<String> getPlayerCommands();
	public void setPlayerCommands(List<String> playerCommands);
	public Map<String, String> getEnvironment();
	public void setEnvironment(Map<String, String> environment);
	public String getSudoUser();
	public void setSudoUser(String sudoUser);
	public ServletContext getServletContext();
}
