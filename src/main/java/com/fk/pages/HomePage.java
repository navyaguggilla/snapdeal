package com.fk.pages;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fk.objectRepository.ObjectRepository;
import com.fk.utility.Functions;
import com.fk.webActions.ElementActions.ElementActions;


public class HomePage extends ObjectRepository {

	Logger log;
	WebDriver driver;
	ElementActions element_Actions;
	Functions functions;
	ObjectRepository obj;
	public String total;
	public String afterincreasingquantitytotal;

	public HomePage(WebDriver driver,Logger log) throws IOException {
		super("Homepage.properties");
		obj = new ObjectRepository("Homepage.properties");
		this.log = log;
		this.driver = driver;
		functions = new Functions();
		element_Actions = new ElementActions(driver);
	}
	public void clickSportShoe()  {
		log.info("Clicking on sport shoes");
		WebElement Mensfasion=element_Actions.findElement(obj.getElement("mensfashion"));
		element_Actions.mouseover(Mensfasion);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("sportshoes"));
		element_Actions.findElement(obj.getElement("sportshoes"));
		element_Actions.click(obj.getElement("sportshoes"));
		log.info("User successfully clicked sport shoes");
	}

	public void SelectfirstProduct()  {
		log.info("User selecting first product form the page");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("shoes"));
		element_Actions.findElement(obj.getElement("shoes"));
		element_Actions.click(obj.getElement("shoes"));
		log.info("Successfully selected first product");
	}

	public void clickAddToCart() {
		log.info("User clicking add to cart button");
		element_Actions.switchToDesiredWindow(1);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("addtocart"));
		element_Actions.findElement(obj.getElement("addtocart"));
		element_Actions.click(obj.getElement("addtocart"));
		log.info("User successfully clicked addtocart button");

	}
	
	public void clickViewcart() {
		log.info("User clicking view cart button");
		element_Actions.switchToDesiredWindow(1);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("viewcart"));
		element_Actions.findElement(obj.getElement("viewcart"));
		element_Actions.click(obj.getElement("viewcart"));
		log.info("User successfully clicked view cart button");

	}
	
	public boolean verifyproductincart()
	{
		log.info("User verifying product in cart");
		element_Actions.switchToDesiredWindow(1);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("productincart"));
		element_Actions.findElement(obj.getElement("productincart"));
		boolean product = element_Actions.checkElementVisibility(obj.getElement("productincart"));
		log.info("User successfully verified product in cart");
		return product;
	}
	
	public void verifysubtotalafterincreasingquantity() {
		log.info("User verifying the subtotal of product after increasing quantity");
		element_Actions.switchToDesiredWindow(1);
		element_Actions.waitUntilVisibilityLocated(obj.getElement("subtotal"));
		element_Actions.findElement(obj.getElement("subtotal"));
		total = element_Actions.getElementText(obj.getElement("subtotal"));
		element_Actions.findElement(obj.getElement("quantity"));
		element_Actions.click(obj.getElement("quantity"));
		element_Actions.findElement(obj.getElement("increasequantity"));
		element_Actions.click(obj.getElement("increasequantity"));
	    afterincreasingquantitytotal = element_Actions.getElementText(obj.getElement("subtotal"));
		log.info("User successfully verified  the subtotal of product after increasing quantity");

	}
	

	public void clickRemove() {
		log.info("User clicking remove button");
		element_Actions.waitUntilVisibilityLocated(obj.getElement("remove"));
		element_Actions.findElement(obj.getElement("remove"));
		element_Actions.click(obj.getElement("remove"));
		log.info("User successfully cliked removed button");

	}
	
	

}