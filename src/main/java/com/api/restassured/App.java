package com.api.restassured;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
class App
{
	 int test=10;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        
       System.out.println(2+5);
       
       App1 app1=new App1();
       
       App app=new App();
       
      app.validateHeader();
      app1.validateHeader();
      app.validateHeader();
      app1.validateHeader();
      String str="TEST Payment";
      String str1=new String("Payment");
      StringBuffer buffer=new StringBuffer("TEST PAYMENT");
      StringBuilder builder=new StringBuilder("NARESH TALESHA");
      
      System.out.println(builder.reverse());
      System.out.println(buffer.reverse());
      System.out.println(str.endsWith("Payment"));
      System.out.println(str.hashCode());
      System.out.println(str1);
      
      String temp="";
      System.out.println(str.length());
      char[] charArray=str.toCharArray();
      System.out.println(charArray.length);
      for(int i=(charArray.length)-1;i>=0;i--) {
    	  temp=temp+charArray[i];
      }
      System.out.println(temp);
      
      temp="";
      for(int i=0;i<charArray.length;i++) {
    	  temp=temp+charArray[i];
      }
      
      System.out.println(temp);
      temp="";
      String ttt=""+'t';
     
      //String a='w';
      for(int i=str.length()-1;i>=0;i--) {
    	  temp=temp+str.charAt(i);
    	 // System.out.println(str.charAt(i));
      }
      
      System.out.println(temp);
      //System.setProperty("webdriver.chrome.driver", "/Users/ntalesha/Downloads/chromedriver-mac-arm6/chromedriver");
	  
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://google.com");
	  driver.close();
    }
    
    public void validateHeader() {
    	System.out.println("Validate Header same class");
    }
}

class App2 extends App
{
	int test=20;
	
	  public static void main( String[] args )
	    {
		  App app=new App2();
		  System.out.println(app.test);
		  
		  App2 app2=new App2();
		  System.out.println(app2.test);
		  System.setProperty("webdriver.chrome.driver", "/Users/ntalesha/Downloads/chromedriver-mac-arm64 4/chromedriver.exe");
		  
		  WebDriver driver=new ChromeDriver();
		  
		  driver.get("https://google.com");
		  
		  //App2 app=new App();
		  
	    }
	
	
	
}
