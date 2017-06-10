package com.local.factories;

class FirefoxV48WebDriverManager

extends WebDriverManager
{
	
	private final static String _VersionXX=
			"48";
	
	private FirefoxWebDriverManager _WebDriverFactoryFirefox;
	
	
	
	public FirefoxV48WebDriverManager()
	{
		
		_WebDriverFactoryFirefox=
				new FirefoxWebDriverManager();
		
	}
	
	
	
	@Override
	protected void createWebDriverInstance()
	{
		
		_WebDriver=
				_WebDriverFactoryFirefox.createWebDriverInstanceForVersionsXX(
						_VersionXX);
		
	}
	
}
