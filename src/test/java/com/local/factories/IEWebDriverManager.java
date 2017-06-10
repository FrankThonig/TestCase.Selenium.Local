package com.local.factories;

import org.openqa.selenium.ie.InternetExplorerDriver;

import com.local.util.misc.path.PathRetrieve;

class IEWebDriverManager

extends WebDriverManager
{
	
	@Override
	protected void createWebDriverInstance()
	{
		
		System.setProperty(
				"webdriver.ie.driver",
				PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
						this,
						"/ext/bin/selenium/driver/ie/32 bit/IEDriverServer.exe"));
		
		
		
		_WebDriver=
				new InternetExplorerDriver();
		
	}
	
}
