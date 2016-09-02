package com.accenture.afpi.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
* Copyright 2015 Accenture. All Rights Reserved. Accenture Confidential and
* Proprietary.
* 
* Disclosure and use of this source code is governed by contract with
* Accenture. Any open source or third party source code referenced in this
* source code is governed by their respective license terms.
*/

public class Logging {
	/**
	 * Getting the Logger Instance
	 */
	public final static Logger LOG = Logger.getLogger(Logging.class);
	
	/**
	 * Declaring the variable to store reference of Logging.
	 */
	private static Logging INSTANCE = null;

	/**
	 * Declaring the variable to store logger Properties File Path.
	 */
	private static String LOGPROPERTIESFILE = null;

	/**
	 * Method is responsible for creating Single Instance of Logging
	 * class.Using SingleTon Pattern Concepts.
	 * 
	 * @return Logging Instance
	 */
	public static Logging getInstance() {
		// checking if the instance of Logging class already created or not.
		if(INSTANCE == null){
			INSTANCE = new Logging();
		}
		return INSTANCE;
	}
	
	/**
	 * Logging Class Constructor
	 */
	private Logging() {
	}

	/**
	 * This method is responsible for loading the logger properties file and
	 * configure the properties with logger instance.
	 */
	public void initializeLogger() {
		
		try {

            try {

                if (LOGPROPERTIESFILE != null && (new java.io.File(LOGPROPERTIESFILE).exists())) {
                    if (LOGPROPERTIESFILE.endsWith("xml")) {
                        DOMConfigurator.configure(LOGPROPERTIESFILE);
                    } else if (LOGPROPERTIESFILE.endsWith("properties")) {
                        PropertyConfigurator.configure(LOGPROPERTIESFILE);
                    }
                } else {
                    BasicConfigurator.configure();
                }
            } catch (Exception initErr) {
                initErr.printStackTrace();
                throw(initErr);
            }
        } catch (Exception err) {
        	throw new RuntimeException("Unable to load logging property "
					+ LOGPROPERTIESFILE);
        }		
		
	}
	
	

	/**
	 * Logs Error Messages
	 * 
	 * @param errorMsg
	 */
	public void logError(String errorMsg) {

		LOG.error(errorMsg);
	}
	
	/**
	 * Logs Warning Messages
	 * 
	 * @param warnMsg
	 */
	public void logWarning(String warnMsg) {

		LOG.warn(warnMsg);
	}
	

	/**
	 * Logs Info Messages
	 * 
	 * @param infoMsg
	 */
	public void logInfo(String infoMsg) {

		LOG.info(infoMsg);
	}

	/**
	 * Logs Debug Messages
	 * 
	 * @param debugMsg
	 */
	public void logDebug(String debugMsg) {

		LOG.debug(debugMsg);
	}

	/**
	 * Logs Fatal Messages.
	 * 
	 * @param fatalMsg
	 */
	public void logFatal(String fatalMsg) {

		LOG.fatal(fatalMsg);
	}

	/**
	 * Method used for retrieving Logger Properties File name.
	 * 
	 * @return Returns the logPropertiesFile.
	 */
	public String getLogPropertiesFile() {
		
		return LOGPROPERTIESFILE;
	}

	/**
	 * Method used for Storing Logger Properties File name.
	 * 
	 * @param logPropertiesFile
	 */
	public void setLogPropertiesFile(String logPropertiesFile) {
		Logging.LOGPROPERTIESFILE = logPropertiesFile;
	}
		
}
