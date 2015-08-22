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

public class DineoutReviews {
	
	
    static WebDriver driver;
    static Wait<WebDriver> wait;

    public static void main(String[] args) throws IOException, InterruptedException {
    	
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://www.dineout.co.in/bangalore/jalpaan-dining-saga-rajajinagar-west-bangalore-7495/review");

        WebElement alleles = driver.findElement(By.xpath("//*[@id='main_div_review']/div[3]"));
        System.out.println("alleles:"+alleles.getText());

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='main_div_review']/div[4]"));

        for(WebElement element:elements) {
            System.out.println(element.getText());
        }
    }
        
}
