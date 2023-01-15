package taskTWO;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openchrome(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
    }
    @Test(priority = 1)
    public void bus() {
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        Dimension reqired =new Dimension(1024,768);
        driver.manage().window().setSize(reqired);
        WebElement back =driver.findElement(By.className("carousel-control-prev"));
        back.click();
        WebElement trip =driver.findElement(By.cssSelector("[onclick=\"populateSearch('1467469338690', 'Chikkamagaluru', '1467467616730', 'Bengaluru');\"]"));
        trip.click();
        WebElement date = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[3]/a"));
        date.click();
        WebElement search = driver.findElement(By.className("btn btn-primary btn-lg btn-block btn-booking"));
        search.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://ksrtc.in/oprs-web/avail/services.do",url);

    }
    @Test(priority = 2)
    public void seat() {
        driver.get("https://ksrtc.in/oprs-web/avail/services.do");
        driver.findElement(By.id("SrvcSelectBtnForward0")).click();
        driver.findElement(By.xpath("//*[@id=\"Forward74\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"Forwardprofile-tab\"]")).click();
        driver.findElement(By.id("mobileNo")).sendKeys("6789125987");
        driver.findElement(By.id("email")).sendKeys("engmarwamohamed4@gmail.com");
        driver.findElement(By.id("passengerNameForward0")).sendKeys("mohamed");
        WebElement gender = driver.findElement(By.id("genderCodeIdForward0"));
        Select genderdropdown =new Select(gender);
        genderdropdown.selectByValue("MALE");
        driver.findElement(By.id("passengerAgeForward0")).sendKeys("30");
        driver.findElement(By.id("Forwarddroping-tab")).click();
        driver.findElement(By.id("Forward-1467467616730")).click();
        WebElement concession = driver.findElement(By.id("concessionIdsForward0"));
        Select con =new Select(concession);
        genderdropdown.selectByValue("GENERAL PUBLIC");
        driver.findElement(By.id("PgBtn")).click();

        String url2 = driver.getCurrentUrl();
        Assert.assertEquals("https://ksrtc.in/oprs-web/booking/revamp/paxInfo.do",url2);

    }
    @AfterTest
    public void closechrome(){
        driver.close();
    }
}


