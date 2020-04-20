package log4jClasses;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Basic {
	
	static Logger logger= Logger.getLogger(Basic.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		
		logger.info("This is info");
		logger.debug("This is debug");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
	

	}

}
