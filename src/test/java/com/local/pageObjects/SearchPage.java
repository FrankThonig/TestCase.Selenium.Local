package com.local.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.local.util.webElement.WebElementSafeActions;

public class SearchPage

extends PageObject
{

	@FindBy(
			name=
				"q")
	private WebElement _SearchTextfield;

	@FindBy(
			id=
				"_fZl")
	private WebElement _SearchButton;
	
	
	
	private int _MaxWaitingTimeForLoadingElementInSeconds=
			5*60;
	
	
	
	public SearchPage(
			WebDriver webDriver)
	{
		
		super(
				webDriver);
		
	}
	
	
	
	public ResultsPage executeSearch(
			String searchTerm)
	{
		
		return clearSearchTextFieldAndEnterSearchTerm(
				searchTerm).clickSearchButton();
		
	}
	
	
	
	private SearchPage clearSearchTextFieldAndEnterSearchTerm(
			String searchTerm)
	{
		
		return clearSearchTextField().enterSearchTerm(
				searchTerm);
		
	}
	
	
	
	private SearchPage clearSearchTextField()
	{
		
		WebElementSafeActions.safeClear(
	    		_WebDriver,
	    		_SearchTextfield,
	    		_MaxWaitingTimeForLoadingElementInSeconds);
		
		
		
		return this;
		
	}
	
	
	
	private SearchPage enterSearchTerm(
			String searchTerm)
	{
		
		WebElementSafeActions.safeSendKeys(
	    		_WebDriver,
	    		_SearchTextfield,
	    		_MaxWaitingTimeForLoadingElementInSeconds,
				searchTerm);
		
		
		
		return this;
		
	}
	
	
	
	private ResultsPage clickSearchButton()
	{
		
		WebElementSafeActions.safeClick(
				_WebDriver,
	    		_SearchButton,
	    		_MaxWaitingTimeForLoadingElementInSeconds);
		
		
		
		return instantiateNewResultsPage();
		
	}
	
	
	
	private ResultsPage instantiateNewResultsPage()
	{
		
		return new ResultsPage(
				_WebDriver);
		
	}
	
}
