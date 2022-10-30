package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import page.CalculatorPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class StringUtil {
    public static String actualLincFrame(WebDriver driver, String pattern, String iframeLink, String linkAttribute) {
        String url = null;
        List<WebElement> src = driver.findElements(By.xpath(iframeLink));
        List<String> links = new ArrayList<>();
        for (WebElement webElement : src) {
            links.add(webElement.getAttribute(linkAttribute));
        }
        for (String link : links) {
            if (link.startsWith(pattern)) {
                url = link;
            }
        }
        return url;
    }
}
