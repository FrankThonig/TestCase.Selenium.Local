package com.local.util.webElement;

import org.openqa.selenium.WebElement;

public class WebElementActions
{
	
	static void clear(
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
			
			webElement.clear();
			
		}
		
	}
	
	static void sendKeys(
			WebElement webElement,
			String keysToSend)
	{
		
		if(webElement!=null)
		{
			
			webElement.sendKeys(
					keysToSend);
			
		}
		
	}
	
	
	
	static void click(
			WebElement webElement)
	{
		
		if(webElement!=null)
		{
		    
			webElement.click();
			
		}
		
	}
	
	
	
	public static String getText(
			WebElement webElement)
	{
		
		String text=
				null;
		
		
		
		if(webElement!=null)
		{
			
			text=
					webElement.getText();
			
		}
		
		
		
		return text;
		
	}
	
}
