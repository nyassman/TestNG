package practice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loop_class {
	WebDriver driver;		
	WebDriverWait Ex;
@BeforeTest(groups="SmokeTest0")
public void setup() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
driver=new ChromeDriver();
driver.get("http://automationpractice.com/index.php");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
Ex= new WebDriverWait(driver,6);

}
@Test
public void signin() {
	driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	WebElement addtocart=driver.findElement(By.xpath("//*[@id=\"order\"]"));
	addtocart.click();
	int i=0;
	do {
		addtocart.click();
		i++;
}
	while (i<4);
for(int x=1; x>3; x++){
	driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[1]"));
}
}
}
