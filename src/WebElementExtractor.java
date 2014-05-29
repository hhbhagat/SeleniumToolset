
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class attempts to separate the WebElement from its parent browser and
 * make it possible to visit other pages in order for the element to exist independent
 * of the browser state
 * @author JayBirdMonster
 * 
 * Version of Selenium used in this implementation is 2.41.0
 */

public class WebElementExtractor {

    private WebDriver driver = null;
    
    public WebElementExtractor(){
        
    }
    
    public WebElementExtractor(WebDriver d){
        driver=d;
    }
    
    //Query must be csspath
    //It picks the first element it finds
    public DetachedElement extract(String query){
        
        driver.findElement(By.cssSelector(query));
        
        
        return null;
    }
    
    public DetachedElement getChildren(){
        
        
        
        return null;
    }
    
    public DetachedElement parseHTML(String source){
        DetachedElement dElem = new DetachedElement();
        
        return dElem;
    }
    
}
