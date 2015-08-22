package firstestngpackage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({SauceOnDemandTestListener.class})
public class Test3 implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {
	
    static ArrayList<String> moversParsed = new ArrayList<String>();
    static int skip = 0;
    private static List<ParseObject>allObjects = new ArrayList<ParseObject>();
    static ArrayList<String> hotel_list = new ArrayList<String>();
    static WebElement RestoName1;
    static WebElement RestoPhone1;
    static WebElement RestoAddress1;
    static WebElement RestoCuisine1;

    public static SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication("serviceprogo", "1a0d84de-cfbf-4866-836d-49a0b576239d");

    
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

   
    private static ThreadLocal<String> sessionId = new ThreadLocal<String>();


    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
        		new Object[]{"firefox", "38", "LINUX"},
                new Object[]{"firefox", "38", "OSX 10.8"},

        };
    }
    private static WebDriver createDriver(String browser, String version, String os) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        if (version != null) {
            capabilities.setCapability(CapabilityType.VERSION, version);
        }
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        capabilities.setCapability("name", "Sauce Sample Test");
        capabilities.setCapability("idle-timeout", 180);
        webDriver.set(new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities));
        sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId().toString());
        return webDriver.get();
    }

    

    @Test(dataProvider = "hardCodedBrowsers")   
    public static void webDriver(String browser, String version, String os) throws Exception, IOException, InterruptedException, ParseException {
    	WebDriver driver = createDriver(browser, version, os);
    	Parse.initialize("l8c3iZRen3hZZCld2J5Bf3HOfKIbEAlSOprEHOax", "mRJNszGCp4eEvzhBMK4U9S76q3IyuYUWtbFH7xJ0");   	

    	final ParseQuery<ParseObject> query = ParseQuery.getQuery("All_Blr_URL");
    	query.limit(1000);
    	query.findInBackground(getAllObjects());
    	
    	Thread.sleep(5000);
       
        Collections.sort(moversParsed);
        
		for (int i = 2000; i < 3000; i++) {
			System.out.println(moversParsed.get(i));
			driver.get(moversParsed.get(i));	
			driver.navigate().refresh();
			//Thread.sleep(5000);

			ParseObject RestaurantReviews = new ParseObject("BlrAddrZom1");
			
			RestaurantReviews.put("hotelUrl", moversParsed.get(i));
			RestaurantReviews.save();
		
		try{
			if(driver.findElement(By.xpath("//html/body/div[3]/div[4]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/div/h1/a/span")) !=null){
				RestoName1 = driver.findElement(By.xpath("//html/body/div[3]/div[4]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/div/h1/a/span"));
				RestaurantReviews.put("hotel_name", RestoName1.getText());
				RestaurantReviews.save();
			}
			
			if(driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span")) != null) {
        		RestoPhone1 = driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span"));
        		RestaurantReviews.put("hotel_phone", RestoPhone1.getText());
        		RestaurantReviews.save();
        	}
			
			if(driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]")) != null) {
        		RestoAddress1 = driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]"));
        		RestaurantReviews.put("hotel_address", RestoAddress1.getText());
        	    RestaurantReviews.save();
        	}
			
		} catch (NoSuchElementException e) {
	        	
	    } catch (TimeoutException e) {
	        	
	    } catch (StaleElementReferenceException e) {
	        	
	    }	
		} 

		driver.quit();	
    }
    
    public static void saveParsedMoverData(List<String> hotel_list){
		moversParsed.clear();
		for(int i=0;i<hotel_list.size();i++){
			moversParsed.add(i,hotel_list.get(i));
			
		} 
	}
    

    public static FindCallback<ParseObject> getAllObjects(){
    	
    	ParseQuery query = new ParseQuery("All_Blr_URL");
        return (new FindCallback<ParseObject>() {

        	public void done(List<ParseObject> parseObject, ParseException e) {
        		
        		
				if (e == null && parseObject != null)
				{
					if(!(parseObject.isEmpty())) {
						int size = parseObject.size();
						int i=0;
						while (i < size) {
							hotel_list.add(parseObject.get(i).getString("zomatoHotelUrl"));
							i++;
						}
						
						saveParsedMoverData(hotel_list);
						
					}
					  allObjects.addAll(parseObject);
					  int limit =1000; 
					  if (parseObject.size() == limit){
	                        skip = skip + limit;
	                        ParseQuery query = new ParseQuery("All_Blr_URL");
	                        query.skip(skip);
	                        query.limit(limit);
	                        query.findInBackground(getAllObjects());
				}
				
			}
        

}
        });
        
        
    }
    
    public static WebDriver getWebDriver() {
        System.out.println("WebDriver" + webDriver.get());
        return webDriver.get();
    }

  
    public String getSessionId() {
        return sessionId.get();
    }

 
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }

}
