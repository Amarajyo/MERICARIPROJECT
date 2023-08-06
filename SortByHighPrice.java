package mericari;
 //Exercise 2 (iOS)
//Scenario#2 Case:1


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;


public class SortByHighPrice {

	public static void main(String[] args)throws MalformedURLException{
		
		 
	        DesiredCapabilities capabilities = new DesiredCapabilities();

	        // Set the device capabilities
	        capabilities.setCapability("platformName", "iOS");
	        capabilities.setCapability("automationName", "XCUITest");
	        capabilities.setCapability("platformVersion", "16.4");
	        capabilities.setCapability("deviceName", "iPhone14");
	        capabilities.setCapability("browserName", "Safari");
	        
	        try {
	            // Initialize the Appium driver
	        	
	        	URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");
	            
	            AppiumDriver driver = new IOSDriver(appiumServerUrl, capabilities);
	            
	            //Open the login page of the website
	            
		        driver.get("https://www.saucedemo.com");
		        
		        //to maxmize the window
		        
		        driver.manage().window().maximize();
		        Thread.sleep(5000);
		        //Find the username and fill with user name
		        
		        driver.findElement(By.id("user-name")).sendKeys("standard_user");
		        
		        //find Password and fill Password
		        
		        driver.findElement(By.id("password")).sendKeys("secret_sauce");
		        
		        //click login button
		        
		        driver.findElement(By.id("login-button")).click();
		        
		        // Locate the dropdown element for price filters
		        WebElement priceFilterDropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span"));
		        
		        // Create a Select object for the dropdown element
		        Select priceFilterSelect = new Select(priceFilterDropdown);

		        // Select the option with the highest price filter
		        priceFilterSelect.selectByVisibleText("Price (high to low)");
		        
		        
		        //Add most three expensive items in to cart(selecting top 3 items since filtered already with price)
		        
		        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		        
		        // Close the browser
		        driver.quit();
		        
		     // Launch the browser again
	            
	            AppiumDriver newdriver = new IOSDriver(appiumServerUrl, capabilities);
		        
              //Open the login page of the website
	            
		        newdriver.get("https://www.saucedemo.com/cart");
		        
		        //to maxmize the window
		        
		        newdriver.manage().window().maximize();
		        
		        
		     // Verify if the three items are still added to the cart
		        int numberOfItemsInCart = newdriver.findElements(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).size();

		        if (numberOfItemsInCart == 3) {
		            System.out.println("All three items are still added to the cart.");
		        } else {
		            System.out.println("The items in the cart do not match the expected count.");
		        }

		        // Close the browser when done
		           newdriver.quit();
		           
	        } catch (Exception e) {
	            e.printStackTrace();
			
		}
		    

	}
}