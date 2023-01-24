package homepage;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.Status;
import com.fk.pages.HomePage;
import com.fk.pages.LoginPage;
import com.fk.utility.Functions;
import com.fk.utility.Log;
import com.fk.utility.XmlReader;
import com.flipkart.base.TestBase;

public class productAddedTocart extends TestBase {

	LoginPage lp;
	Functions functions;
	HomePage homepage;
	
	public Logger log;

	public void loader() throws IOException {
		log = LogManager.getLogger(productAddedTocart.class.getName());
		functions = new Functions();
		lp = new LoginPage(driver, log);
		homepage = new HomePage(driver, log);
	}

	@Test()
	public void registrationFormWithBlank()throws IOException, InterruptedException {
		test = extent.createTest("Product added to cart");
		log.info("Started==Product added to cart");

		test.log(Status.INFO, "User clicking on sport shoes");
		homepage.clickSportShoe();
		test.log(Status.PASS, "User successfully clicked on sport shoes");
		
		test.log(Status.INFO, "User selecting first product");
		homepage.SelectfirstProduct();
		test.log(Status.PASS, "Successfully user selected first product");
		
		test.log(Status.INFO, "User clicking on addtocart button ");
		homepage.clickAddToCart();
		test.log(Status.PASS, "User successfully clicked add to cart button");
		
		test.log(Status.INFO, "User clicking view cart button");
		homepage.clickViewcart();
		test.log(Status.PASS, "User successfully clicked view cart button");
		
		test.log(Status.INFO, "User verifying product in cart");
		homepage.verifyproductincart();
		test.log(Status.PASS, "successfully user verified product in add cart");
		
		test.log(Status.INFO, "User verifying the subtotal of product after increasing quantity");
		homepage.verifysubtotalafterincreasingquantity();
		Assert.assertNotEquals(homepage.total, homepage.afterincreasingquantitytotal,"Total value is same");
		test.log(Status.PASS, "User successfully verifed the subtotal of product after increasing quantity");
		
	}

	@DataProvider(name = "login")
	public Object[][] newUserRegistration() throws IOException, ParserConfigurationException, SAXException {
		XmlReader reader = new XmlReader();
		return reader.testData("login");
	}

	
	  public void closeSession() throws InterruptedException {
	  driver.quit();
	   }
}
