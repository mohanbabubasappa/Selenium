package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {

	Properties prop;

	public ConfigData()
	{
		prop=new Properties();
		FileInputStream fis;
		
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public String getBrowserName()
	{
		return prop.getProperty("browser");
	}

	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
}
