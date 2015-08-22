
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
        WebDriverWait wait = new WebDriverWait(driver, 15);
        
        PrintStream ps = new PrintStream("//Users//rsalecha//Downloads//jate_test//JalPaanBurrp_All_Reviews.txt");
        PrintStream orig = System.out;
        System.setOut(ps);

       
        
        List<String> hotel_list = new ArrayList<String>();
        hotel_list.add("http://www.burrp.com/bangalore/jalpaan-uttar-dakshin-jayanagar-listing/360538");
        hotel_list.add("http://www.burrp.com/bangalore/jalpaan-rajajinagar-listing/152829");
        hotel_list.add("http://www.burrp.com/bangalore/jalpaan-jayanagar-listing/46990");
        hotel_list.add("http://www.burrp.com/bangalore/jalpaan-jlb-road-listing/378600");
        hotel_list.add("http://www.burrp.com/chennai/jalpaan-thousand-lights-listing/378606");
        hotel_list.add("http://www.burrp.com/mumbai/jalpaan-borivali-west-listing/386399");
        hotel_list.add("http://www.burrp.com/hyderabad/jalpaan-somajiguda-listing/335583");
        hotel_list.add("http://www.burrp.com/hyderabad/jalpaan-eatstreet-prenderghast-road-listing/390163");
        hotel_list.add("http://www.burrp.com/hyderabad/jalpaan-eat-street-public-garden-road-listing/388235");
        
	
		for (int i = 0; i < hotel_list.size(); i++) {
			System.out.println(hotel_list.get(i));
			driver.get(hotel_list.get(i));	     		        								
        									        
			Thread.sleep(1000);
	        
	        //Code to click load-more button for all Reviews
	        if(driver.findElement(By.xpath("//a[@id='seeMoreRev']")) != null) {
	        	try{
	        		while(driver.findElement(By.xpath("//a[@id='seeMoreRev']")) != null){
	        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='seeMoreRev']")));
	        			driver.findElement(By.xpath("//a[@id='seeMoreRev']")).click();
	        			Thread.sleep(2000);
	        			}
	        		} catch (NoSuchElementException e) {
	        	System.out.println("load-more button doesn't exist :NoSuchElementException ");
	        } catch (TimeoutException e) {
	        	System.out.println("load-more button doesn't exist: TimeoutException");
	        } catch (StaleElementReferenceException e) {
	        	System.out.println("load-more button doesn't exist: StaleElementReferenceException");
	        }
	        } else {
	        	System.out.println("load-more is null");
	        }
	        
	        Thread.sleep(1000);
	        
	        WebElement alleles = driver.findElement(By.xpath("//div[contains(@id,'reviewblock')]"));
	        System.out.println("alleles:"+alleles.getText().length());
	        List<WebElement> elements = alleles.findElements(By.xpath("//div[contains(@id,'review_')]"));
	    
	        System.out.println(elements.size());
	        for(WebElement element:elements) {
	        	System.out.println("========================================");
	            System.out.println(element.getText());
	        }
    } 
		
		  System.setOut(orig);
	        ps.close();
	        
        PrintStream final_results = new PrintStream("//Users//rsalecha//Downloads//jate_test//JalPaanBurrp_Final_Results.txt");
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
			int count = countWord(MenuListIterator.next(),"//Users//rsalecha//Downloads//jate_test//JalPaanBurrp_All_Reviews.txt");
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

