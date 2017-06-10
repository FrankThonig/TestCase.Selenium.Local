package com.local.factories;

class FirefoxV45WebDriverManager

extends WebDriverManager
{
	
	private final static String _VersionXX=
			"45";
	
	private FirefoxWebDriverManager _WebDriverFactoryFirefox;
	
	
	
	public FirefoxV45WebDriverManager()
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
