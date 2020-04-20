package log4jClasses;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class CheckProperties {
	
	static Logger logger= Logger.getLogger(CheckProperties.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("This is info");
		logger.debug("This is debug");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
	

	}

}
