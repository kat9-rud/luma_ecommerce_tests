package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    private WebDriverConfig config;
    public WebDriverProvider(){
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        createWebDriver();
    }

    private void createWebDriver(){
        if (config.getBrowser().equals("chrome")){
            WebDriverManager.chromedriver().setup();
        } else if (config.getBrowser().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
        }
        else {
            throw new RuntimeException("no such driver");
        }

        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();

        if (!config.getRemoteUrl().isEmpty()) {
            String remote = config.getRemoteUrl();
            String login = config.getRemoteLogin();
            String pass = config.getRemotePass();

            Configuration.remote = remote.replace("//", "//" + login + ":" + pass + "@") + "/wd/hub";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
    }
}
