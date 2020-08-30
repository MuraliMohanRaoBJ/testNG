package com.myStore.test;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.myStore.pageObject.*;

public class TshirtTest extends Tshirts{

	BasePage bp;
	Tshirts ts;
	IndexPage ip;
	CartPage cp;
	
	@BeforeSuite
    public void setup() throws IOException{
        initialization();
        bp=new BasePage();
        ts=new Tshirts();
        ip=new IndexPage();
        cp=new CartPage();
       }
	
	
	@Test(priority=1)
	public void orderTshirt(){
		ip.chooseTabTshirts();
		ts.verifyPageLoaded();
		ts.addToCart("Faded Short Sleeve T-shirts");
		cp.openCart();
		cp.deleteProductfromCart();
	}
}
