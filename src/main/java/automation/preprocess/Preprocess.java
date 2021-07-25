package automation.preprocess;

import deersheep.automation.utility.PropertiesTool;
import deersheep.automation.webdriver.WebDriverWrapper;
import org.openqa.selenium.WebDriver;

import static deersheep.automation.utility.PropertiesTool.generateBuildNumber;

public class Preprocess {

    public static WebDriver setupWebDriverWrapper() {
        WebDriverWrapper wrapper = WebDriverWrapper.getInstance();
        wrapper.setPageLoadTimeoutInSec(30);
        wrapper.addRemoteNode("local", "http://10.60.80.69:4040/wd/hub");
        wrapper.addRemoteNode("remote", "http://10.60.91.40:4040/wd/hub");
        return wrapper.getInstance().getWebDriver(
                PropertiesTool.getProperty("environment", "browser"),
                PropertiesTool.getProperty("environment", "machine"));
    }

    public static void main(String[] args) {
        generateBuildNumber();
    }

}
