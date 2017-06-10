package com.local.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class PageObject
{
	
	protected WebDriver _WebDriver;
	
	
	
	protected PageObject(
			WebDriver webDriver)
	{
		
		if(webDriver==null)
		{
			
			throw new RuntimeException(
					"WebDriver instance is NULL");
			
		}
		
		
		
		_WebDriver=
				webDriver;
		
		
		
		PageFactory.initElements(
				_WebDriver,
				this);
		
	}
	
}
