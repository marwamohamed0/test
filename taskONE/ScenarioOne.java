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

public class ScenarioOne {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void openchrome(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
    }


    @Test (priority = 1)

    public void signin() {
        driver.get("https://www.amazon.com/");
        Dimension required =new Dimension(1024,768);
        driver.manage().window().setSize(required);
        
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
        String hello =driver.findElement(By.cssSelector("[id=\"nav-link-accountList-nav-line-1\"]")).getText();
        Assert.assertEquals(hello,"Hello, marwa");
    }

    @Test(priority = 2)
    public void item() {
        driver.get("https://www.amazon.com/ref=nav_ya_signin");
        //search
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("car accessories");
        WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
        submit.click();
        //add item
        WebElement item =driver.findElement(By.className("s-easy-mode-ingress-icon"));
        item.click();
        WebElement add =driver.findElement(By.cssSelector("[data-csa-c-content-id=\"easy-mode-action-item-emAddToList\"]"));
        add.click();

        WebElement list =driver.findElement(By.className("a-link-normal"));
        list.click();
       WebElement addcart =driver.findElement(By.className("a-button a-button-normal a-button-primary a-button-icon wl-info-aa_add_to_cart"));
        addcart.click();

        //WebElement item =driver.findElement(By.className("a-section aok-relative s-image-square-aspect"));
        //item.click();
        //WebElement add =driver.findElement(By.id("add-to-cart-button"));
        //add.click();

         //verify item added

        String cartnum =driver.findElement(By.id("nav-cart-count")).getText();
        Assert.assertEquals(cartnum,"1");

    }



    @AfterTest
    public void closechrome(){
        driver.close();
    }


}


