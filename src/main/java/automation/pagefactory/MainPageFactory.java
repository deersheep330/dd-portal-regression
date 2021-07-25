package automation.pagefactory;

import automation.page.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageFactory {

    public static MainPage getMainPage(WebDriver driver) {
        return new MainPage(driver);
    }

}
