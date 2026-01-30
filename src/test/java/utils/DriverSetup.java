package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverSetup {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            Properties prop = new Properties();
            try {
                prop.load(DriverSetup.class.getClassLoader()
                        .getResourceAsStream("config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String browser = System.getProperty("browser");
            if (browser == null) {
                browser = prop.getProperty("browser");
            }

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else {
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
