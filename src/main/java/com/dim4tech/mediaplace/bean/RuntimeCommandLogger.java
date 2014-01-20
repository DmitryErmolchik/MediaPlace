package com.dim4tech.mediaplace.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeCommandLogger {

	private static final Logger internalLogger = LoggerFactory
			.getLogger(RuntimeCommandLogger.class);
	
	private BufferedReader bufferedReader;
	private StringBuilder stringBuilder;
	private String line;
	
	public void log(Process process, Logger logger) {
		stringBuilder = new StringBuilder();
		bufferedReader = new BufferedReader(
				new InputStreamReader(process.getErrorStream()));
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + '\n');
			}
			logger.error(stringBuilder.toString());
		} catch (IOException e) {
			internalLogger.error(e.getLocalizedMessage());
		}

		bufferedReader = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		stringBuilder = new StringBuilder();
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + '\n');
			}
			logger.info(stringBuilder.toString());
		} catch (IOException e) {
			internalLogger.error(e.getLocalizedMessage());
		}
	}
	
	public String getErrorLog(Process process) {
		stringBuilder = new StringBuilder();
		bufferedReader = new BufferedReader(
				new InputStreamReader(process.getErrorStream()));
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line + '\n');
			}
		} catch (IOException e) {
			internalLogger.error(e.getLocalizedMessage());
		}
		return stringBuilder.toString();
	}
}
