
package com.onlinebanking.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	public  String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
