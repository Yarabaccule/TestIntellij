import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestExample {
    private WebDriver driver;

    @Before
    public void inicio() {
//        baixar o cucumber for java
//      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yara\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/geckodriver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @After
    public void fim() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testeRegistro() {

        achar(By.className("lnXdpd"));
        esperar(2000);
        tirarScreenshot();


    }

    private void achar(By by) {
        driver.findElement(by);
    }

    private void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tirarScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "screenshots/screenshot_" + timestamp + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
            System.out.println("Screenshot salvo em: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
