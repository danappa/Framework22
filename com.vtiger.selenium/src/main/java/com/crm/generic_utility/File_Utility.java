package com.crm.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Genric class for data driven testing
 * @author Santhosh
 *
 */

public class File_Utility {
	/**
	 * This is generic method for reading the data from property file
	 * @param key
	 * @return String
	 * @throws IOException
	 */

	public String getPropertykey(String key) throws IOException
	{
	//	FileInputStream fis=new FileInputStream("./common_Data.properties");
		FileInputStream fis=new FileInputStream(IpathConstant.PROPERTYFILE_PATH1);
	    Properties p=new Properties();
	    p.load(fis);
	    String value = p.getProperty(key);
	    return value;
	}

}
