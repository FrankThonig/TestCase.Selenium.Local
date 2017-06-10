package com.local.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.local.util.misc.path.PathRetrieve;

/*
 * In a local (i.e. non-grid) Selenium 3.4 setup Firefox version 47- need to set system property webdriver.firefox.marionette to false:
 * 
 * System.setProperty(
 * 	"webdriver.firefox.marionette",
 * 	"false");
 * 
 * However, Firefox version 48+ need system property webdriver.firefox.marionette to be set to true.
 * Therefore in this setup Firefox version 47- cannot be run in parallel to version 48+.
 */

class FirefoxWebDriverManager
{
	
	private WebDriver _WebDriver;
	
	private DesiredCapabilities _DesiredCapabilities;
	private FirefoxOptions _FirefoxOptions;
	
	
		
	WebDriver createWebDriverInstanceForVersionsXX(
			String versionXX)
	{
		
		_WebDriver=
				null;
		
		
		
		System.setProperty(
				"webdriver.gecko.driver",
				PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
						this,
						"/ext/bin/selenium/driver/firefox/geckodriver-v0.15.0-win32.exe"));
		
		
		
		if(versionXX.equalsIgnoreCase(
				"45"))
		{
			
			_WebDriver=
					createWebDriverInstanceForVersions47AndBelow(
							versionXX);
			
		}
		else if(versionXX.equalsIgnoreCase(
				"48")
				||
				versionXX.equalsIgnoreCase(
						"52"))
		{
			
			_WebDriver=
					createWebDriverInstanceForVersions48AndAbove(
							versionXX);
			
		}
		
		
		
		return _WebDriver;
		
	}
	
	
	
	private WebDriver createWebDriverInstanceForVersions47AndBelow(
			String versionXX)
	{
		
		System.setProperty(
				"webdriver.firefox.marionette",
				"false");
		
		System.setProperty(
				"webdriver.firefox.bin",
				createPathToFirefoxBinary(
						versionXX));
		
		
		
		_WebDriver=
				new FirefoxDriver();
		
		
		
		return _WebDriver;
		
	}
	
	
	
	private WebDriver createWebDriverInstanceForVersions48AndAbove(
			String versionXX)
	{
		
		//Only ONE alternative mentioned below needs to be executed to instantiate the WebDriver. However, several alternatives are given to demonstrate a variety possibilities.
		
		//Alternative 1
		_WebDriver=
				createWebDriverInstanceForVersions48AndAbove_DesiredCapabilities(
						versionXX);
		
		
		
		//Alternative 2
//		_WebDriver=
//				createWebDriverInstanceForVersions48AndAbove_FirefoxOptions(
//						versionXX);
		
		
		
		return _WebDriver;
		
	}
	
	
	
	private WebDriver createWebDriverInstanceForVersions48AndAbove_DesiredCapabilities(
			String versionXX)
	{
		
		_DesiredCapabilities=
				new DesiredCapabilities();
		
		_DesiredCapabilities.setCapability(
				"firefox_binary",
				createPathToFirefoxBinary(
						versionXX));
		
		
		
		_WebDriver=
				new FirefoxDriver(
						_DesiredCapabilities);
		
		
		
		return _WebDriver;
		
	}
	
	
	
	public WebDriver createWebDriverInstanceForVersions48AndAbove_FirefoxOptions(
			String versionXX)
	{
		
		_FirefoxOptions=
				new FirefoxOptions();
		
		_FirefoxOptions.setBinary(
				createPathToFirefoxBinary(
						versionXX));
		
		
		
		_WebDriver=
				new FirefoxDriver(
						_FirefoxOptions);
		
		
		
		return _WebDriver;
		
	}
	
	
	
	private String createPathToFirefoxBinary(
			String versionXX)
	{
		
		return PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
				this,
				"/ext/bin/browser/firefox/v" +
				versionXX +
				"/firefox.exe");
		
	}
	
}
