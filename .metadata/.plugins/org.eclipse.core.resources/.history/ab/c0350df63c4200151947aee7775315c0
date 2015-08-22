
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.DynamicGraph.Status;



public class E2E_Test {
	
	
    static WebDriver driver;
    static Wait<WebDriver> wait;
    static Map<Integer, String> hm = new HashMap<Integer, String>();

    public static void main(String[] args) throws IOException, InterruptedException {
    	
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        PrintStream ps = new PrintStream("//Users//rsalecha//Downloads//jate_test//TripAdvisor_all_Review_Jalpaan.txt");
        PrintStream orig = System.out;
        System.setOut(ps);
        
        List<String> hotel_list = new ArrayList<String>();
        
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297628-d2507314-Reviews-Jalpaan_Restaurant-Bengaluru_Bangalore_Karnataka.html");
      /*  
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g304553-d2483817-Reviews-Dining_Saga_Jalpaan-Mysore_Karnataka.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g304556-d4549796-Reviews-Jalpaan-Chennai_Madras_Tamil_Nadu.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297586-d4162400-Reviews-Jalpaan-Hyderabad_Telangana.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297628-d2507314-Reviews-Jalpaan_Restaurant-Bengaluru_Bangalore_Karnataka.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g295424-d6812873-Reviews-Jalpaan-Dubai_Emirate_of_Dubai.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297628-d6440352-Reviews-Jalpaan_Dining_Saga-Bengaluru_Bangalore_Karnataka.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297628-d5536134-Reviews-Jalpaan_Uttar_Dakshin-Bengaluru_Bangalore_Karnataka.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g304554-d6726991-Reviews-Jalpaan-Mumbai_Bombay_Maharashtra.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g297586-d6216243-Reviews-Jalpaan-Hyderabad_Telangana.html");
        hotel_list.add("http://www.tripadvisor.com/Restaurant_Review-g494941-d8105074-Reviews-Jalpaan-Indore_Madhya_Pradesh.html");
*/
		for (int i = 0; i < hotel_list.size(); i++) {
			System.out.println(hotel_list.get(i));
			driver.get(hotel_list.get(i));	     		        								
        									        
			//GetReviewsPage();
			try {
	        	List<WebElement> mores = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
	        	for(WebElement more1:mores) {	
	        		if(more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).isEnabled()){
	        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")));
	        			more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).click();
	    			    break;
	        		}
	        	}	
	        	
	        	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]"))).isEnabled()){
	        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]")));
	        		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'xCloseGreen')]"))).click();
	        	}
	        	
	    	} catch (NoSuchElementException e) {
	        	System.out.println("NoSuchElementException ");
	        } catch (TimeoutException e) {
	        	System.out.println("TimeoutException");
	        } catch (StaleElementReferenceException e) {
	        	System.out.println("StaleElementReferenceException");
	        }

			try{
				
				
					try {
	                	List<WebElement> mores = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
	                	for(WebElement more1:mores) {	
	                		if(more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).isEnabled()){
	                			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")));
	                			more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).click();
	                			
	            			    break;
	                		}
	                	}	
	                	
	                	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]"))).isEnabled()){
	                		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]")));
	                		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'xCloseGreen')]"))).click();
	                	
	                	}
	                	
	            	} catch (NoSuchElementException e) {
	                	System.out.println("NoSuchElementException ");
	                } catch (TimeoutException e) {
	                	System.out.println("TimeoutException");
	                } catch (StaleElementReferenceException e) {
	                	System.out.println("StaleElementReferenceException");
	                }
					//GetReviews();
					List<WebElement> alleles2 = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
			    	for(WebElement element:alleles2) {
			    		System.out.println("========================================");
			    		System.out.println(element.getText());
			    	}
				
					
	        	while (driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).isEnabled()) {	
	        		driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).click();
	        		Thread.sleep(500);
	        
	        		driver.get(driver.getCurrentUrl());
	        		
	        		//GetReviewsPage();
	        		try {
	                	List<WebElement> mores = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
	                	for(WebElement more1:mores) {	
	                		if(more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).isEnabled()){
	                			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")));
	                			more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).click();
	                			
	            			    break;
	                		}
	                	}	
	                	
	                	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]"))).isEnabled()){
	                		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]")));
	                		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'xCloseGreen')]"))).click();
	                		
	                	}
	                	
	            	} catch (NoSuchElementException e) {
	                	System.out.println("NoSuchElementException ");
	                } catch (TimeoutException e) {
	                	System.out.println("TimeoutException");
	                } catch (StaleElementReferenceException e) {
	                	System.out.println("StaleElementReferenceException");
	                }
	    			//GetReviews();
	        		List<WebElement> alleles3 = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
	            	for(WebElement element:alleles3) {
	            		System.out.println("========================================");
	            		System.out.println(element.getText());
	            	}
	        	}

	        } catch (NoSuchElementException e) {
	        	System.out.println("NoSuchElementException ");
	        } catch (TimeoutException e) {
	        	System.out.println("TimeoutException");
	        } catch (StaleElementReferenceException e) {
	        	System.out.println("StaleElementReferenceException");
	        } 
		} 
		
		System.setOut(orig);
	    ps.close();
	        
        PrintStream final_results = new PrintStream("//Users//rsalecha//Downloads//jate_test//TripAdvisor_Jalpaan_Final_Results.txt");
        PrintStream results_ps = System.out;
        System.setOut(final_results);
		
		Scanner s = new Scanner(new File("//Users//rsalecha//Downloads//jate_test//Jalpaan_Menu.txt"));
		
		List<String> list = new ArrayList<String>();
		
		while (s.hasNext()){
		    list.add(s.useDelimiter(",").next());
		}
		s.close();
		
		Iterator<String> MenuListIterator = list.iterator();
		while (MenuListIterator.hasNext()) {
			int count = countWord(MenuListIterator.next(),"//Users//rsalecha//Downloads//jate_test//TripAdvisor_all_Review_Jalpaan.txt");
		}
		
		Map<Integer, String> newMap = new TreeMap(Collections.reverseOrder());
		newMap.putAll(hm);
		
		System.out.println("Final Results : Count, Menu Item");
		System.out.println("=================================================");
		
		for (Map.Entry entry : newMap.entrySet()) {
			
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		   
		}
		
		 System.out.println("=================================================");
		 
		System.setOut(results_ps);
        final_results.close();
		
        
    }
    
    public static void GetReviewsPage() throws InterruptedException {
    	try {
        	List<WebElement> mores = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
        	for(WebElement more1:mores) {	
        		if(more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).isEnabled()){
        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")));
        			more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).click();
        			Thread.sleep(6000);
    			    break;
        		}
        	}	
        	
        	if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]"))).isEnabled()){
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'wide overlay withBackdrop')]")));
        		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'xCloseGreen')]"))).click();
        		Thread.sleep(6000);
        	}
        	
    	} catch (NoSuchElementException e) {
        	System.out.println("NoSuchElementException ");
        } catch (TimeoutException e) {
        	System.out.println("TimeoutException");
        } catch (StaleElementReferenceException e) {
        	System.out.println("StaleElementReferenceException");
        }
    }
  
    public static void GetReviews() {
    	List<WebElement> alleles2 = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
    	for(WebElement element:alleles2) {
    		System.out.println("========================================");
    		System.out.println(element.getText());
    	}
   }
    
    
    public static int countWord(String word, String file_name) throws FileNotFoundException {
		int count = 0;
		Scanner scanner = new Scanner(new File(file_name));
		boolean found = false;
		
		
		while (scanner.hasNextLine()) {
		    String nextToken = scanner.nextLine();
		   
		    if(found){
		    	found = false;
		    }
		    if (containsIgnoreCase(nextToken,word))
		    {
		    	found = true;
		    	count++;
		    }
		    
		    
		}
		if(count > 0){
			hm.put(count, word);
		}
		return count;
	}
	
	public static boolean containsIgnoreCase(final String str, final String searchStr) {
	    if (str == null || searchStr == null) {
	        return false;
	    }
	    final int len = searchStr.length();
	    final int max = str.length() - len;
	    for (int i = 0; i <= max; i++) {
	        if (str.regionMatches(true, i, searchStr, 0, len)) {
	            return true;
	        }
	    }
	    return false;
	}
	
        
}

