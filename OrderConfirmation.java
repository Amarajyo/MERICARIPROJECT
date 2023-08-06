package mericari;


//Exercise 2 (iOS)
//Scenario#1

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.ios.IOSDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.By;
	import java.net.MalformedURLException;
	import java.net.URL;

	public class OrderConfirmation {
		
			public static <webdriver> void main(String[] args)throws MalformedURLException { 
				   
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
				        
				        //password Password and fill Password
				        
				        driver.findElement(By.id("password")).sendKeys("secret_sauce");
				        
				        //click login button
				        
				        driver.findElement(By.id("login-button")).click();
				        
				        //select a item and add to cart
				        
				        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
				        
				        //go to shopping cart
				        
				        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
				        
				        //click on checkout
				        driver.findElement(By.id("checkout")).click();
				        
				        //fill the shipping details
				        driver.findElement(By.id("first-name")).sendKeys("Amara");
				        driver.findElement(By.id("last-name")).sendKeys("Jyothi");
				        driver.findElement(By.id("postal-code")).sendKeys("243-0422");
				        
				        //click continue and finish
				        
				        driver.findElement(By.id("continue")).click();
				        driver.findElement(By.id("finish")).click();
				        
				        
				        //find the final confirmation Message for order
				        String ActualMessage =driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
			
				        String ExpectedMessage = "Thank you for your order!";
				
				        if(ActualMessage.equalsIgnoreCase(ExpectedMessage))
		          
				          System.out.println("Your order is suceessful!");
				
			           else 
				          System.out.println(" Your order is not suceessful!");
			           driver.quit();
			    
			        } catch (Exception e) {
			            e.printStackTrace();
					
				}
					
				   
			}

	}


