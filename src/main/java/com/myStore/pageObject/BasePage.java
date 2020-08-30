package com.myStore.pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static WebElement element;
	public static Actions actions ;
	public static int itemcount=0;
	
	public static final By logo=By.className("logo img-responsive");
	
	
	public BasePage(){
		try {
			prop = new Properties();
			prop.load(new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/Config/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		try{
    	String browserName = prop.getProperty("browser");
		System.out.println("The selected browser is "+browserName);
		String seleniumFolderPath =System.getProperty("user.dir")+"/src/test/resources/drivers/";
		System.out.println("Tyhe path is "+seleniumFolderPath);
        switch(browserName){
		case "Chrome" :
			ChromeOptions c= new ChromeOptions();
            c.addArguments("--incognito");
            System.setProperty("webdriver.chrome.driver", seleniumFolderPath+"chromedriver.exe");
            driver=new ChromeDriver();
            break;
		case "IE" :
            System.setProperty("webdriver.ie.driver", seleniumFolderPath+"IEDriverServer.exe");
            driver=new InternetExplorerDriver();
            break;
		}
		wait= new WebDriverWait(driver,1000);
	    driver.manage().deleteAllCookies();;
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("url"));
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
	    actions= new Actions(driver);
    }catch(Exception e){
    	e.printStackTrace();
    }
	}
	
	
	/** Common method to click on any locator**/
	public void click(By locator){
		try{
        System.out.println(" Click Method " +locator);
        element=wait.until(ExpectedConditions.elementToBeClickable(locator));
        System.out.println(" locator" +locator);
        element.click();
    }catch(Exception e){
    	e.printStackTrace();
    }
	}
	
	
	/** Common method to enter text**/
	public void enterText(By locator,String text){
		try{
        element=wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }catch(Exception e){
    	e.printStackTrace();
    }
	}

}
