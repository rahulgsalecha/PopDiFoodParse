
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.DynamicGraph.Status;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class tripadvisor_parse {
	
	
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) throws IOException, InterruptedException {
    	//System.setProperty("webdriver.chrome.driver", "/Users/rsalecha/Downloads/chromedriver-1");
    	
    	//driver = new ChromeDriver();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://www.tripadvisor.com/Restaurant_Review-g297628-d7004438-Reviews-BelgYum-Bengaluru_Bangalore_Karnataka.html#REVIEWS");
  
        List<WebElement> reviews = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
        
        for(WebElement reviews1:reviews) {
        	try {
        		if(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink')]"))).isDisplayed()){
        			reviews1.findElement(By.xpath("//span[contains(@class,'moreLink')]")).click();
        			Thread.sleep(1000);
        		}
        	} catch (NoSuchElementException e) {
            	System.out.println("NoSuchElementException ");
            } catch (TimeoutException e) {
            	System.out.println("TimeoutException");
            } catch (StaleElementReferenceException e) {
            	System.out.println("StaleElementReferenceException");
            }
        	
        	WebElement full_review = reviews1.findElement(By.xpath("//div[contains(@class,'dyn_full_review')]"));
        	System.out.println("========================================");
        	System.out.println(full_review.getText());
        }	
        /*if(driver.findElement(By.xpath("//span[contains(@class,'moreLink')]")).isEnabled()) {
        	System.out.println("about to click");
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink')]")));
        	driver.findElement(By.xpath("//span[contains(@class,'moreLink')]")).click();
        }
        
        Thread.sleep(1000);*/
  
        //driver.get(driver.getCurrentUrl());
        
        	System.out.println("========================================");
        	System.out.println("========================================");
        	System.out.println("========================================");
        	System.out.println("========================================");
        	System.out.println("========================================");
        List<WebElement> alleles = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
        
        /*for(WebElement element:alleles) {
        	alleles1 = element.findElements(By.xpath("//div[contains(@class,'reviewSelector')]"));
        }*/

        
    for(WebElement element:alleles) {
        	System.out.println("========================================");
            System.out.println(element.getText());
        }
        
        try{
        while (driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).isEnabled()) {
        	System.out.println("about to click Next");
        	
             driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).click();
        
        Thread.sleep(1000);
        
        driver.get(driver.getCurrentUrl());
        
        List<WebElement> alleles1 = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
        for(WebElement element:alleles1) {
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
}