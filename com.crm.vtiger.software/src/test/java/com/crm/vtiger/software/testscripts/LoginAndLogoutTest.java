package com.crm.vtiger.software.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndLogoutTest {
	
	
	public WebDriver driver=null;
	
	@Test
	public void vtigerLoginTest() {
		
		String browsername= System.getProperty("browser");
		System.out.println(browsername);
		
		String urlname = System.getProperty("url");
		System.out.println(urlname);
		
		String username = System.getProperty("username");
		System.out.println(username);
		
		String password = System.getProperty("password");
		System.out.println(password);
		
		
		
		if(browsername.equalsIgnoreCase("edge")) {
		
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}else {
			System.out.println("no other browser is installed");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(urlname);
		//login to app
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Actions action = new Actions(driver);
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(admin).perform();
		WebElement logout = driver.findElement(By.linkText("Sign Out"));
		action.moveToElement(logout).click().perform();
		
		
	}

}
