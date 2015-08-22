
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
        
        PrintStream ps = new PrintStream("//Users//rsalecha//Downloads//jate_test//JalPaanDineOut_All_Reviews.txt");
        PrintStream orig = System.out;
        System.setOut(ps);

       
        
        List<String> hotel_list = new ArrayList<String>();
        
        //hotel_list.add("http://www.dineout.co.in/hyderabad/jalpaan-eat-street-secunderabad-secunderabad-14852/review");
        hotel_list.add("http://www.dineout.co.in/bangalore/jalpaan-dining-saga-rajajinagar-west-bangalore-7495/review");
        
        hotel_list.add("http://www.dineout.co.in/bangalore/jalpaan-jayanagar-south-bangalore-7281/review");
        hotel_list.add("http://www.dineout.co.in/chennai/jalpaan-thousand-lights-central-chennai-10620/review");
        hotel_list.add("http://www.dineout.co.in/hyderabad/jalpaan-begumpet-central-hyderabad-6893/review");
        //hotel_list.add("http://www.dineout.co.in/hyderabad/jalpaan-express-kukatpally-north-hyderabad-15074/review");
	
		for (int i = 0; i < hotel_list.size(); i++) {
			System.out.println(hotel_list.get(i));
			driver.get(hotel_list.get(i));	     	
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main_div_review']/div[3]")));

			if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='main_div_review']/div[3]"))).isDisplayed()){
				WebElement alleles = driver.findElement(By.xpath("//*[@id='main_div_review']/div[3]"));
				System.out.println("alleles:"+alleles.getText());
			} else {
				System.out.println("FALSE");
				break;
			}

			
				List<WebElement> elements = driver.findElements(By.xpath("//*[@id='main_div_review']/div[4]"));

				for(WebElement element:elements) {
					System.out.println(element.getText());
				}
			
    } 
		
		  System.setOut(orig);
	        ps.close();
	        
        PrintStream final_results = new PrintStream("//Users//rsalecha//Downloads//jate_test//JalPaanDineOut_Final_Results.txt");
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
			int count = countWord(MenuListIterator.next(),"//Users//rsalecha//Downloads//jate_test//JalPaanDineOut_All_Reviews.txt");
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

