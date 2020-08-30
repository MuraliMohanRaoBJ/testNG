package com.myStore.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public static final By iconOk=By.className("icon-ok");
	public static final By productCartmessage=By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2");
	public static final By closeCart=By.className("cross");
	public static final By viewCart=By.xpath("//a[@title='View my shopping cart']");
	public static final By iconTrash=By.className("icon-trash");
	
	
	public void openCart(){
		try{
			element=driver.findElement(viewCart);
			element.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void deleteProductfromCart(){
		try{
			element=wait.until(ExpectedConditions.elementToBeClickable(iconTrash));
			element=driver.findElement(iconTrash);
			element.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
