package com.myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndexPage extends BasePage{
	
	
	public static final By searchBox=By.className("search_query form-control ac_input");
	public static final By searchButton=By.name("submit_search");
	public static final By tabWomen=By.xpath("//div[@id='block_top_menu']//ul/li/a[@title='Women']");
	public static final By tabDresses=By.xpath("(//div[@id='block_top_menu']//ul/li/a[@title='Dresses'])[2]");
	public static final By tabTshirts=By.xpath("(//div[@id='block_top_menu']//ul/li/a[@title='T-shirts'])[2]");
	public static final By featuredPopular=By.xpath("Popular");
	public static final By featuredBestSeller=By.xpath("//li/a[contains(text(),'Best Sellers')]");
	
	
	public void chooseTabWomen(){
		try{
			element=wait.until(ExpectedConditions.elementToBeClickable(tabWomen));
			driver.findElement(tabWomen).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void chooseTabDresses(){
		try{
			element=wait.until(ExpectedConditions.elementToBeClickable(tabDresses));
			driver.findElement(tabDresses).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void chooseTabTshirts(){
		try{
			element=wait.until(ExpectedConditions.elementToBeClickable(tabTshirts));
			driver.findElement(tabTshirts).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
