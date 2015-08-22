package firstestngpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SeventhTestNGFile {
	
	static WebDriver driver;
    static Wait<WebDriver> wait;
    static ArrayList<String> moversParsed = new ArrayList<String>();
    static int skip = 0;
    private static List<ParseObject>allObjects = new ArrayList<ParseObject>();
    static ArrayList<String> hotel_list = new ArrayList<String>();

    @Test
    public static void test() throws IOException, InterruptedException, ParseException {
    	
    	Parse.initialize("x3w9shkNvQrxPvvDUK11iHG3JBmyEPMnNsbvoDCa", "tlN0OAmxpCOzKVh3K0liNdnluhL3hGMybAG6zrz6");

    	final ParseQuery<ParseObject> query = ParseQuery.getQuery("All_Blr_URL");
    	query.limit(1000);
    	query.findInBackground(getAllObjects());

        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Collections.sort(moversParsed);
		for (int i = 600; i < 700; i++) {
			System.out.println(moversParsed.get(i));
			driver.get(moversParsed.get(i));	
        
        //Code to click on Reviews tab
		try{
			if(driver.findElement(By.xpath("//a[contains(@class,'default-section-title everyone empty')]")) !=null){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'default-section-title everyone empty')]")));
			driver.findElement(By.xpath("//a[contains(@class,'default-section-title everyone empty')]")).click();
			}
		} catch (NoSuchElementException e) {
	        	System.out.println("Reviews tab button doesn't exist :NoSuchElementException ");
	    } catch (TimeoutException e) {
	        	System.out.println("Reviews tab button doesn't exist: TimeoutException");
	    } catch (StaleElementReferenceException e) {
	        	System.out.println("Reviews tab button doesn't exist: StaleElementReferenceException");
	    }		
        
        Thread.sleep(500);
        
        //Code to click load-more button for all Reviews
        try{
        	if(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null) {
        		while(driver.findElement(By.xpath("//div[@class = 'load-more']")) != null){
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'load-more']")));
        			driver.findElement(By.xpath("//div[@class = 'load-more']")).click();
        		}
        	} else {
            	System.out.println("load-more is null");
        	}
        } catch (NoSuchElementException e) {
        	System.out.println("load-more button doesn't exist :NoSuchElementException ");
        } catch (TimeoutException e) {
        	System.out.println("load-more button doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	System.out.println("load-more button doesn't exist: StaleElementReferenceException");
        }
         
        Thread.sleep(500);
        
        try{
        	if(driver.findElement(By.xpath("//div[contains(@class,'zs-following-list pbot')]")) != null){
        		WebElement alleles = driver.findElement(By.xpath("//div[contains(@class,'zs-following-list pbot')]"));
        		List<WebElement> elements = alleles.findElements(By.xpath("//div[@itemprop='review']"));
        		
        		System.out.println("elements size:" + elements.size());
                for(WebElement element:elements) {
                	ParseObject RestaurantReviews = new ParseObject("ZomBlr_1");
                    RestaurantReviews.put("hotelUrl", hotel_list.get(i));
                    //String title = StringUtils.substringBetween(element.getText(), "RATED", "Like");
                    RestaurantReviews.put("hotelFullReview", element.getText());
                    //RestaurantReviews.put("hotelReview",title);
                    RestaurantReviews.save();
                }
        	}
        } catch (TimeoutException e) {
        	System.out.println("zs-following-list pbot doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	System.out.println("zs-following-list pbot doesn't exist: StaleElementReferenceException");
        } catch (NoSuchElementException e) {
        	System.out.println("zs-following-list pbot doesn't exist :NoSuchElementException ");
        }
     } 
		driver.quit();	
    }
    
    public static void saveParsedMoverData(List<String> hotel_list){
		moversParsed.clear();
		for(int i=0;i<hotel_list.size();i++){
			moversParsed.add(i,hotel_list.get(i));
			
		} 
		
		//System.out.println("moversParsed List: " + moversParsed.size());
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
}
