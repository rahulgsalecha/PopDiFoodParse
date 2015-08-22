package firstestngpackage;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.ParseQuery;
import org.parse4j.callback.FindCallback;


public class AddressRestaurantBLR2 {
	
	static WebDriver driver;
    static Wait<WebDriver> wait;
    static ArrayList<String> moversParsed = new ArrayList<String>();
    static int skip = 0;
    private static List<ParseObject>allObjects = new ArrayList<ParseObject>();
    static ArrayList<String> hotel_list = new ArrayList<String>();
    static WebElement RestoName1;
    static WebElement RestoPhone1;
    static WebElement RestoAddress1;
    static WebElement RestoCuisine1;

    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
    	
    	Parse.initialize("x3w9shkNvQrxPvvDUK11iHG3JBmyEPMnNsbvoDCa", "tlN0OAmxpCOzKVh3K0liNdnluhL3hGMybAG6zrz6");    	

    	final ParseQuery<ParseObject> query = ParseQuery.getQuery("All_Blr_URL");
    	query.limit(1000);
    	query.findInBackground(getAllObjects());
    	
    	Thread.sleep(6000);

    	System.setProperty("webdriver.chrome.driver", "/Users/rsalecha/Downloads/chromedriver-1");
    	driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Collections.sort(moversParsed);
        
		for (int i = 2160; i < hotel_list.size(); i++) {
			System.out.println(moversParsed.get(i));
			driver.get(moversParsed.get(i));	

			ParseObject RestaurantReviews = new ParseObject("MyZomAddr");
			
			RestaurantReviews.put("hotelUrl", moversParsed.get(i));
			RestaurantReviews.save();
		
		try{
			if(driver.findElement(By.xpath("//html/body/div[3]/div[4]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/div/h1/a/span")) !=null){
				RestoName1 = driver.findElement(By.xpath("//html/body/div[3]/div[4]/div/div[2]/div[2]/div/div/div[1]/div/div[3]/div/h1/a/span"));
				//System.out.println(RestoName.getText());
				RestaurantReviews.put("hotel_name", RestoName1.getText());
				RestaurantReviews.save();
			}
			
			if(driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span")) != null) {
        		RestoPhone1 = driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span"));
        			//System.out.println(RestoPhone.getText());
        			RestaurantReviews.put("hotel_phone", RestoPhone1.getText());
        			RestaurantReviews.save();
        	}
			
			if(driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]")) != null) {
        		RestoAddress1 = driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]"));
        			//System.out.println(RestoAddress.getText());
        			RestaurantReviews.put("hotel_address", RestoAddress1.getText());
        			RestaurantReviews.save();
        	}
			
		} catch (NoSuchElementException e) {
	        	//System.out.println("Reviews tab button doesn't exist :NoSuchElementException ");
	    } catch (TimeoutException e) {
	        	//System.out.println("Reviews tab button doesn't exist: TimeoutException");
	    } catch (StaleElementReferenceException e) {
	        	//System.out.println("Reviews tab button doesn't exist: StaleElementReferenceException");
	    }		
 /*
        try{
        	if(driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span")) != null) {
        		RestoPhone1 = driver.findElement(By.xpath("//*[@id='phoneNoString']/div/span/span[1]/span"));
        			//System.out.println(RestoPhone.getText());
        			RestaurantReviews.put("hotel_phone", RestoPhone1.getText());
        			RestaurantReviews.save();
        	}
        	
        	
        } catch (NoSuchElementException e) {
        	//System.out.println("load-more button doesn't exist :NoSuchElementException ");
        } catch (TimeoutException e) {
        	//System.out.println("load-more button doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	//System.out.println("load-more button doesn't exist: StaleElementReferenceException");
        }
*/
        /*
        try{
        	if(driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]")) != null) {
        		RestoAddress1 = driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[1]/div[2]/div/div[4]"));
        			//System.out.println(RestoAddress.getText());
        			RestaurantReviews.put("hotel_address", RestoAddress1.getText());
        			RestaurantReviews.save();
        	}
        } catch (NoSuchElementException e) {
        	//System.out.println("load-more button doesn't exist :NoSuchElementException ");
        } catch (TimeoutException e) {
        	//System.out.println("load-more button doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	//System.out.println("load-more button doesn't exist: StaleElementReferenceException");
        }
*/
        /*
        try{
        	if(driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]")) != null) {
        		RestoCuisine1 = driver.findElement(By.xpath("//*[@id='mainframe']/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]"));
        			//System.out.println("Cuisine: "+ RestoCuisine.getText());
        			RestaurantReviews.put("hotel_cuisine", RestoCuisine1.getText());
        			//RestaurantReviews.save();
        	}
        } catch (NoSuchElementException e) {
        	//System.out.println("load-more button doesn't exist :NoSuchElementException ");
        } catch (TimeoutException e) {
        	//System.out.println("load-more button doesn't exist: TimeoutException");
        } catch (StaleElementReferenceException e) {
        	//System.out.println("load-more button doesn't exist: StaleElementReferenceException");
        }
        */
        //System.out.println(RestoName1.getText() + "," + RestoPhone1.getText() + ", '" + RestoAddress1.getText()+ "' , '" + RestoCuisine1.getText() + "' ," + hotel_list.get(i));
        //RestaurantReviews.saveInBackground();;
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
}