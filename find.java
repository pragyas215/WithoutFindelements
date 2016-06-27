package Withoutfindelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

public class find {

	public static void main(String args[]) throws InterruptedException{
           WebDriver driver=new FirefoxDriver();
		//assignment 1
		driver.get("http://10.0.1.86");
		driver.get("http://10.0.1.86/tatoc");
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement e = (WebElement)js.executeScript("document.getElementsByClassName('greenbox')[0].click();");
		
		
		//assignment 2
		driver.switchTo().frame("main");
		
		
		
		String color1 =((WebElement)js.executeScript("return document.getElementById(\"answer\");")).getAttribute("class");
		
		driver.switchTo().frame("child");
		
		
		String color2 =((WebElement)js.executeScript("return document.getElementById('answer');")).getAttribute("class");
		System.out.println(color1+color2);
		
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		while(!color1.equals(color2))
	    {  
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			
		js.executeScript("document.getElementsByTagName('a')[0].click();");
			
		
		color1 =((WebElement)js.executeScript("return document.getElementById('answer');")).getAttribute("class");
		
		driver.switchTo().frame("child");
			
		color2 =((WebElement)js.executeScript("return document.getElementById('answer');")).getAttribute("class");	
		
		if(color1.equals(color2)){
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().frame("main");
	    		
	    		js.executeScript("document.getElementsByTagName('a')[1].click();");
	    	   	break;
		    	}
		 }
		
		//assignment 3
		Thread.sleep(1000);
		
		WebElement element =(WebElement)js.executeScript("return document.getElementById('dragbox');");
		WebElement target=(WebElement)js.executeScript("return document.getElementById('dropbox');");
		System.out.println("gbtoiigjg");
		
		(new Actions(driver)).dragAndDrop(element,target).build().perform();
		System.out.println("gbtoiigjg");
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		
		//assignment 4
		String  handle= driver.getWindowHandle(); 
		driver.findElement(By.xpath("//a[@href='#']")).click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		((WebElement) js.executeScript("return document.getElementById('name');")).sendKeys("Pragya");
		 js.executeScript("document.getElementById('submit').click();");
		driver.switchTo().window(handle);
		List<WebElement> ds= driver.findElements(By.xpath("//a[@href='#']"));
		ds.get(1).click();
		
		// assignment 5
		Thread.sleep(1000);
		js.executeScript("document.getElementsByTagName('a')[0].click();");
		String ck=((WebElement)js.executeScript("return document.getElementById('token');")).getText();
		int y= ck.length(); String s="";
		for(int x=7;x<y ; x++){
			s+=ck.charAt(x);
		}
		System.out.println(s);
		Cookie token = new Cookie("Token", s);
		driver.manage().addCookie(token);
		List<WebElement> dd= driver.findElements(By.xpath("//a[@href='#']"));
		dd.get(1).click();
	
		
}
}