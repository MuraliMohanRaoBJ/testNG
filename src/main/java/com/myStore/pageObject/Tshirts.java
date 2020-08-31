package com.myStore.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Tshirts extends IndexPage{
	
	public static final By breadCrumb=By.className("breadcrumb clearfix");
	public static final By titleCatalogue=By.xpath("//p[@class='title_block' and contains(text(),'Catalog')]");
	public static final By size_S=By.xpath("//input[@type='checkbox' and @id='layered_id_attribute_group_1']");
	public static final By size_M=By.xpath("//input[@type='checkbox' and @id='layered_id_attribute_group_2']");
	public static final By size_L=By.xpath("//input[@type='checkbox' and @id='layered_id_attribute_group_3']");
	public static final By colourOrabge=By.xpath("//a[text()='Orange']");
	public static final By clourBlue=By.xpath("//a[text()='Blue']");
	public static final By sortProduct=By.id("uniform-selectProductSort");
	public static final By addToCart=By.xpath("//a[@title='Add to cart']");
	public static final By iconOk=By.className("icon-ok");
	public static final By productCartmessage=By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
	
	public static void checkFeature(String feature, String value){
		try{
		By checkBox=By.xpath("//a[text()='"+value+"']//parent::label/preceding-sibling::div/span/input");
		System.out.println("Selecting "+value+" for "+feature);
		element=driver.findElement(checkBox);
		element.click();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public void verifyPageLoaded(){
		try{
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(breadCrumb));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void selectSortOrder(String sortOrder){
		try{
			Select order=new Select(driver.findElement(sortProduct));
			order.selectByVisibleText(sortOrder);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void addToCart(String productName){
		try{
			By productname=By.xpath("//a[@title='"+productName+"' and @class='product-name']");
			element=driver.findElement(productname);
			Assert.assertTrue(element.isDisplayed());
			actions.moveToElement(element).perform();
			element=driver.findElement(addToCart);
			if(element.isDisplayed()){
				element.click();
				System.out.println(productName+" has been selected");
				itemcount++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
