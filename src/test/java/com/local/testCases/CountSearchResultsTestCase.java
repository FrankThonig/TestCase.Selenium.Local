package com.local.testCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.local.factories.WebDriverManager;
import com.local.factories.WebDriverManagerFactory;
import com.local.pageObjects.SearchPage;
import com.local.testData.TestData;
import com.local.util.misc.string.StringContent;
import com.local.util.webDriver.WebDriverNavigate;

public class CountSearchResultsTestCase
{
	
	private ThreadLocal<String> _URLOfSearchWebsite=
			new ThreadLocal<String>();
    private ThreadLocal<Integer> _AmountOfResultsToBeChecked=
    		new ThreadLocal<Integer>();

    private ThreadLocal<WebDriverManagerFactory> _WebDriverManagerFactory=
    		new ThreadLocal<WebDriverManagerFactory>();
    private ThreadLocal<WebDriverManager> _WebDriverManager=
    		new ThreadLocal<WebDriverManager>();

    
    
    @BeforeMethod
	@Parameters({
		"urlOfSearchWebsite",
		"amountOfResultsToBeChecked"})
	public void beforeMethod(
			String urlOfSearchWebsite,
			int amountOfResultsToBeChecked)
    {
    	
    	_WebDriverManagerFactory.set(
    			new WebDriverManagerFactory());
    	
    	_URLOfSearchWebsite.set(
    			urlOfSearchWebsite);
    	
    	_AmountOfResultsToBeChecked.set(
    			amountOfResultsToBeChecked);
    	
    }

    
    
    @AfterMethod
	public void afterMethod()
    {
    	
    	if(_WebDriverManager.get()!=null)
    	{
    		
        	_WebDriverManager.get().quitWebDriver();
        	
    	}
    	
    }
    
    
    
	@Test(
			dataProvider=
				"testData",
			dataProviderClass=
				TestData.class)
	public void testSearchForSearchTermAndCountOccurencesInResults(
			String browserName,
			String searchTerm)
	{
		
		WebDriver webDriver=
				null;
    	
    	List<String> resultsList=
    			null;
    	
    	
		
		_WebDriverManager.set(
    			_WebDriverManagerFactory.get().createWebDriverManager(
						browserName));
		
    	if(_WebDriverManager.get()!=null)
    	{
    		
    		webDriver=
    				_WebDriverManager.get().createWebDriver();
        	
    	}
    	
    	
    	
		WebDriverNavigate.navigateToURL(
				webDriver,
				_URLOfSearchWebsite.get());
		
		resultsList=
				new SearchPage(
						webDriver).executeSearch(
								searchTerm).getResultsList();
		
		
		
		Assert.assertTrue(
				isSearchTermContainedInResultsListWithExpectedAmountOfOccurences(
						searchTerm,
						resultsList),
				"Search term not contained in the first " +
				_AmountOfResultsToBeChecked.get() +
				" search results.");
		
	}
	
	
	
    private boolean isSearchTermContainedInResultsListWithExpectedAmountOfOccurences(
    		String searchTerm,
    		List<String> resultsList)
    {
    	
    	boolean isSearchTermContainedInResultsListWithExpectedAmountOfOccurences=
    			false;
    	
    	
		
		if(resultsList!=null
				&&resultsList.size()>=_AmountOfResultsToBeChecked.get())
		{
			
			if(_AmountOfResultsToBeChecked.get()>0)
			{
				
				for(int index=0; index<_AmountOfResultsToBeChecked.get(); index++)
				{
					
					if(!isSearchTermContainedInCurrentResult(
							searchTerm,
							resultsList.get(
									index)))
					{
						
						isSearchTermContainedInResultsListWithExpectedAmountOfOccurences=
								false;
						
						break;
						
					}
					else if(index+1==_AmountOfResultsToBeChecked.get())
					{
						
						isSearchTermContainedInResultsListWithExpectedAmountOfOccurences=
								true;
						
					}
					
				}
				
			}
			
		}
		
		
		
		return isSearchTermContainedInResultsListWithExpectedAmountOfOccurences;
    	
    }
    
    private boolean isSearchTermContainedInCurrentResult(
    		String searchTerm,
    		String currentResult)
    {
    	
    	return StringContent.isString1ContainedInString2IgnoreCase(
    			searchTerm,
    			currentResult);
    	
    }
	
}
