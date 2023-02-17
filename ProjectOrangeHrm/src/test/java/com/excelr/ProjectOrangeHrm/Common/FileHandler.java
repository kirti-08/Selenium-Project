package com.excelr.ProjectOrangeHrm.Common;

import java.io.FileInputStream;
import java.util.Properties;

public class FileHandler {

	public static String getPropertyValue(String filename, String key) {

		try {

			FileInputStream fis = new FileInputStream("testdata\\" + filename + ".properties");
			
			Properties pop = new Properties();
			pop.load(fis);
			
			return pop.getProperty(key);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
