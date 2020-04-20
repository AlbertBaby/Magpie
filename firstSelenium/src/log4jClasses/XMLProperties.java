package log4jClasses;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class XMLProperties {
	
	static Logger logger = Logger.getLogger(XMLProperties.class);  
    
    public static void main(String[] args) {  
        DOMConfigurator.configure("DOM.xml");  
        logger.debug("This is debug message");  
        logger.info("This is info message");  
        logger.warn("This is warn message");  
        logger.error("This is error message");  
        logger.fatal("This is fatal message");  
    }  

}
