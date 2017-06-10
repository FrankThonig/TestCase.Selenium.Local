package com.local.factories;

class FirefoxV52WebDriverManager

extends WebDriverManager
{
	
	private final static String _VersionXX=
			"52";
	
	private FirefoxWebDriverManager _WebDriverFactoryFirefox;
	
	
	
	public FirefoxV52WebDriverManager()
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
