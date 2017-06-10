package com.local.testData;

import org.testng.annotations.DataProvider;

/*
 * In this local (i.e. non-grid) Selenium setup Firefox version 47- cannot be run in parallel to version 48+. See class FirefoxWebDriverManager for Details.
 */

public class TestData
{
	
	private static String firefoxV45=
			"firefoxV45";
	
	private static String firefoxV48=
			"firefoxV48";
	
	private static String firefoxV52=
			"firefoxV52";
	
	private static String chrome=
			"chrome";
	
	private static String ie=
			"ie";
	
	
	
	private static String monday=
			"monday";
	
	private static String tuesday=
			"tuesday";
	
	
	
	private static Object _Data[][];
	
	
	
    @DataProvider(
    		name=
    			"testData",
    		parallel=
    			true)
    public static Object[][] createTestData()
    {

    	//The object array with a first dimension of 8 is to be used when choosing Firefox versions 48 and 52 for the test setup
    	_Data=
    			new Object[8][2];

    	//The object array with a first dimension of 8 is to be used when choosing Firefox version 47 for the test setup
//    	_Data=
//    			new Object[6][2];
		
		
		
		_Data[0][0]=
				chrome;
		
		_Data[0][1]=
				monday;
		
		
		
		_Data[1][0]=
				chrome;
		
		_Data[1][1]=
				tuesday;
		
		
		
		_Data[2][0]=
				ie;
		
		_Data[2][1]=
				monday;
		
		
		
		_Data[3][0]=
				ie;
		
		_Data[3][1]=
				tuesday;
    	
    	

    	//The object array with a first dimension of 8 is to be used when choosing Firefox versions 48 and 52 for the test setup
		_Data[4][0]=
				firefoxV48;
		
		_Data[4][1]=
				monday;
		
		

    	//The object array with a first dimension of 8 is to be used when choosing Firefox versions 48 and 52 for the test setup
		_Data[5][0]=
				firefoxV48;
		
		_Data[5][1]=
				tuesday;
    	
    	

    	//The object array with a first dimension of 8 is to be used when choosing Firefox versions 48 and 52 for the test setup
		_Data[6][0]=
				firefoxV52;
		
		_Data[6][1]=
				monday;
		
		

    	//The object array with a first dimension of 8 is to be used when choosing Firefox versions 48 and 52 for the test setup
		_Data[7][0]=
				firefoxV52;
		
		_Data[7][1]=
				tuesday;
    	
    	
    	
		
		

    	//The object array with a first dimension of 8 is to be used when choosing Firefox version 47 for the test setup
//		_Data[4][0]=
//				firefoxV45;
//		
//		_Data[4][1]=
//				monday;
		
		
		
    	//The object array with a first dimension of 8 is to be used when choosing Firefox version 47 for the test setup
//		_Data[5][0]=
//				firefoxV45;
//		
//		_Data[5][1]=
//				tuesday;
		
		
		
    	return _Data;
				
	}
	
}
