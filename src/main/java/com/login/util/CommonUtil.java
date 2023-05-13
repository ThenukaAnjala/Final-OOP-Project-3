package com.login.util;

//import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonUtil {
	
		public static final Logger log = Logger.getLogger(QueryUtil.class.getName());
		public static final Properties properties = new Properties();
		
		static {
			try {
				// create reader object 
				//FileReader reader =  new FileReader("config.properties");
					
				properties.load(DBConnectionUtil.class.getResourceAsStream("config.properties"));
				
			}
			catch(IOException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
}
