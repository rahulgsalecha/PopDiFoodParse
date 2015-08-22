
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

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLDivElement;


public class tripadvisor_htmlunit {
	
	 final static WebClient webClient;
	 
	    static {
	        webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_11);
	        webClient.getOptions().setJavaScriptEnabled(true);
	        webClient.getOptions().setRedirectEnabled(true);
	        webClient.getOptions().setCssEnabled(true);
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	        webClient.getOptions().setThrowExceptionOnScriptError(true);
	        webClient.getOptions().setUseInsecureSSL(true);
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
	        webClient.waitForBackgroundJavaScriptStartingBefore(10000);
	        webClient.setJavaScriptTimeout(2147483647);
	        webClient.setCssErrorHandler(new SilentCssErrorHandler());
	        webClient.waitForBackgroundJavaScript(5000);
	        webClient.setRefreshHandler(new ThreadedRefreshHandler());
	        webClient.getCookieManager().setCookiesEnabled(true);
	    }
	
    public static void main(String[] args) throws IOException, InterruptedException {

    	HtmlPage currentPage = webClient.getPage("http://www.tripadvisor.com/Restaurant_Review-g297628-d2507314-Reviews-Jalpaan_Restaurant-Bengaluru_Bangalore_Karnataka.html");
    	System.out.println("Test 1 - page length="+currentPage.asText().length());
    	
    	try {
    	
    		//if (currentPage.getFirstByXPath("//div[starts-with(@id, 'review_')]") != null) {
    		
    		List<HtmlElement> mores = (List<HtmlElement>) currentPage.getByXPath("//div[starts-with(@id, 'review_')]");
    		for(HtmlElement more1:mores) {
    			if (more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]") != null) {
    				HtmlSpan target_div = more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]");
    				target_div.click();
    				break;
    			}
    		}
    		
    		if(currentPage.getFirstByXPath("//div[contains(@class,'wide overlay withBackdrop')]") != null) {
    			HtmlDivision target_div1 = currentPage.getFirstByXPath("//div[contains(@class,'wide overlay withBackdrop')]");
    			target_div1.click();
    		}
    		
        //}
    	} catch (NoSuchElementException e) {
        	System.out.println("NoSuchElementException ");
        } catch (TimeoutException e) {
        	System.out.println("TimeoutException");
        } catch (StaleElementReferenceException e) {
        	System.out.println("StaleElementReferenceException");
        }
    	
    	try{
    		try {
		    	
	    		//if (currentPage.getFirstByXPath("//div[starts-with(@id, 'review_')]") != null) {
	    		
	    		List<HtmlElement> mores = (List<HtmlElement>) currentPage.getByXPath("//div[starts-with(@id, 'review_')]");
	    		for(HtmlElement more1:mores) {
	    			if (more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]") != null) {
	    				HtmlSpan target_div = more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]");
	    				target_div.click();
	    				break;
	    			}
	    		}
	    		
	        //}
	    	} catch (NoSuchElementException e) {
	        	System.out.println("NoSuchElementException ");
	        } catch (TimeoutException e) {
	        	System.out.println("TimeoutException");
	        } catch (StaleElementReferenceException e) {
	        	System.out.println("StaleElementReferenceException");
	        }
	
			List<HtmlDivision> alleles2 = (List<HtmlDivision>) currentPage.getByXPath("//div[contains(@class,'deckB review_collection')]");
			for(HtmlDivision element:alleles2) {
				System.out.println("========================================");
				System.out.println(element.asText());
			} 
			
    		while (currentPage.getByXPath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]") != null) {
    			System.out.println("about to click Next");
    			HtmlAnchor target_div2 = currentPage.getFirstByXPath("//a[contains(@class,'nav next rndBtn rndBtnGreen')]");
    			target_div2.click();
        
    			try {
    		    	
    	    		//if (currentPage.getFirstByXPath("//div[starts-with(@id, 'review_')]") != null) {
    	    		
    	    		List<HtmlElement> mores = (List<HtmlElement>) currentPage.getByXPath("//div[starts-with(@id, 'review_')]");
    	    		for(HtmlElement more1:mores) {
    	    			if (more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]") != null) {
    	    				HtmlSpan target_div = more1.getFirstByXPath("//span[contains(@class,'moreLink ulBlueLinks')]");
    	    				target_div.click();
    	    				break;
    	    			}
    	    		}
    	    		
    	        //}
    	    	} catch (NoSuchElementException e) {
    	        	System.out.println("NoSuchElementException ");
    	        } catch (TimeoutException e) {
    	        	System.out.println("TimeoutException");
    	        } catch (StaleElementReferenceException e) {
    	        	System.out.println("StaleElementReferenceException");
    	        }
		
    			List<HtmlDivision> alleles3 = (List<HtmlDivision>) currentPage.getByXPath("//div[contains(@class,'deckB review_collection')]");
    			for(HtmlDivision element:alleles3) {
    				System.out.println("========================================");
    				System.out.println(element.asText());
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