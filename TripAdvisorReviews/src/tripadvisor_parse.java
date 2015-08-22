
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tripadvisor_parse {
	
	
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) throws IOException, InterruptedException {

        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        
        driver.get("http://www.tripadvisor.com/Restaurant_Review-g297628-d7004438-Reviews-BelgYum-Bengaluru_Bangalore_Karnataka.html#REVIEWS");
        
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
        	while (driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).isEnabled()) {
        		System.out.println("about to click Next");
        		driver.findElement(By.xpath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]")).click();
        		Thread.sleep(500);
        
        		driver.get(driver.getCurrentUrl());
        		
        		 try {
        	        	List<WebElement> mores = driver.findElements(By.xpath("//div[starts-with(@id, 'review_')]"));
        	        	for(WebElement more1:mores) {
        	        		if(more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).isEnabled()){
        	        			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")));
        	        			more1.findElement(By.xpath("//span[contains(@class,'moreLink ulBlueLinks')]")).click();
        	        			break;
        	        		}
        	        	}	
        	    	} catch (NoSuchElementException e) {
        	        	System.out.println("NoSuchElementException ");
        	        } catch (TimeoutException e) {
        	        	System.out.println("TimeoutException");
        	        } catch (StaleElementReferenceException e) {
        	        	System.out.println("StaleElementReferenceException");
        	        }
        	  
        
        		List<WebElement> alleles2 = driver.findElements(By.xpath("//div[contains(@class,'deckB review_collection')]"));
        		for(WebElement element:alleles2) {
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