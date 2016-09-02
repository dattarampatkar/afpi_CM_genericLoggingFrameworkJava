package com.accenture.afpi.logging;

import com.accenture.afpi.logging.Logging;

public class LoggingWrapper {
	
	private static Logging objLogging = null;
	
	public LoggingWrapper(){
				
	}
	
	public static Boolean LogMessageFromBroker(String LogMessage, String LogLevel, String LogPropertyPath){
		
		try{		
			
			objLogging = Logging.getInstance();
			objLogging.setLogPropertiesFile(LogPropertyPath);
			objLogging.initializeLogger();
			
			switch(LogLevel.toUpperCase()) {
				case "DEBUG":
					objLogging.logDebug(LogMessage);
					break;
				case "INFO":
					objLogging.logInfo(LogMessage);
					break;
				case "ERROR":
					objLogging.logError(LogMessage);
					break;
				case "WARNING":
					objLogging.logWarning(LogMessage);
					break;				
				case "FATAL":
					objLogging.logFatal(LogMessage);
					break;			
	        }
		}catch(Exception e){
			System.out.println("Not able to print the log message using Logger " + LogMessage);
			e.printStackTrace();
			throw(e);
		}
		return true;		
	} 

}
