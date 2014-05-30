
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class attempts to separate the WebElement from its parent browser and
 * make it possible to visit other pages in order for the element to exist
 * independent of the browser state
 *
 * @author JayBirdMonster
 *
 * Version of Selenium used in this implementation is 2.41.0
 */
public class WebElementExtractor {

    private WebDriver driver = null;

    public WebElementExtractor() {

    }

    public WebElementExtractor(WebDriver d) {
        driver = d;
    }

    //Query must be csspath
    //It picks the first element it finds
    //returns null if query is not found
    public DetachedElement extract(String query) {

        try {
            driver.findElement(By.cssSelector(query));
        } catch (Exception e) {
            return null;
        }
        return parseHTML(driver.findElement(By.cssSelector(query)).getAttribute("innerHTML"));
    }

    public DetachedElement getChildren() {

        return null;
    }

    public DetachedElement parseHTML(String source) {
        DetachedElement dElem = new DetachedElement();

        //clean out useless script tags
        cleanScript(source);

        String[] splitSource = source.split("[" + String.format("%n") + "|" + String.format(" ") + "]");
        ArrayList<String> splitArr = new ArrayList<String>();
        for (String a : splitSource) {
            splitArr.add(a);
        }

        ListIterator<String> iterSplit = splitArr.listIterator();

        while (iterSplit.hasNext()) {
            if (iterSplit.next().contains("<")) {

                String tagName = iterSplit.previous().replace("<", "");
                iterSplit.next();
                ArrayList<String> tempTagList = new ArrayList<String>();
                String firstAttr = iterSplit.next();
                iterSplit.previous();

                Map<String, String> attrPair = new HashMap<String, String>();

                while (!iterSplit.next().contains(">")) {
                    String[] pair = iterSplit.next().split("=");
                    attrPair.put(pair[0], pair[1]);
                }
                dElem.addTag(tagName, attrPair);
            }
        }

        return dElem;
    }

    private boolean arrContains(String q, ArrayList<String> s) {
        for (String a : s) {
            if (a.contains(q)) {
                return true;
            }
        }
        return false;
    }

    private void cleanScript(String source) {
        while (source.contains("<script>") || source.contains("</script>")) {
            int index = source.indexOf("<script>");
            int endInd = source.indexOf("</script>");
            source = source.substring(0, index) + source.substring(endInd, source.length() - 1);
        }

    }

}
