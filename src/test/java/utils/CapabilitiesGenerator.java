package utils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String driverPath = "src/test/resources/webdrivers";
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(("Operational system: " + os + "; Driver path: " + driverPath));
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/linux/chromedriver");
        }

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
//        options.addArguments("--headless");
        options.addArguments("-incognito");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-extensions");
        return options;
    }
}
