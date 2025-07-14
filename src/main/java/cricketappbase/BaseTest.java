package cricketappbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ExtentManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentTest test;




    public void setUpDriver(){
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--window-size=1920,1080");
    driver=new ChromeDriver(options);
        if (!System.getenv().containsKey("CI")) { // In GitHub Actions, "CI" env variable is always set to "true"
            options.addArguments("user-data-dir=/path/to/profile");
        }
//driver=new ChromeDriver();
    extentReports= ExtentManager.getInstance();

}
public void tearDownDriver(){
    if(driver!=null){
        driver.quit();
    }
    if(extentReports!=null){
        extentReports.flush();
    }
}


}
