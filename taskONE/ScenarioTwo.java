package taskONE;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScenarioTwo {
    WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void openchrome(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
    }


    @Test(priority = 1)

    public void deals() {
        driver.get("https://www.amazon.com/");
        Dimension required =new Dimension(1024,768);
        driver.manage().window().setSize(required);

        //sign in
        WebElement register = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        register.click();
        WebElement email = driver.findElement(By.cssSelector("[type=\"email\"]"));
        email.sendKeys("engmarwamohamed4@gmail.com");
        WebElement con = driver.findElement(By.id("continue"));
        con.click();
        WebElement password = driver.findElement(By.cssSelector("[type=\"password\"]"));
        password.sendKeys("24112009");
        WebElement sign = driver.findElement(By.id("signInSubmit"));
        sign.click();
        /////


        WebElement today =driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
           today.click();
        WebElement grocary = driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[18]/label/span"));
           grocary.click();
        WebElement headphones =driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[19]/label/span"));
           headphones.click();
        WebElement sale =driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[2]/span[6]/ul/li[2]/div/a/span"));
           sale.click();
        WebElement item =driver.findElement(By.xpath("//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/div/a[2]/div"));
           item.click();
        WebElement cart = driver.findElement(By.id("dealsx_atc_btn-announce"));
            cart.click();

        String cartno =driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartno,"1");

    }
    @AfterTest
    public void closechrome(){
        driver.close();
    }
}

