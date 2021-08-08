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

public class action_facebook {
	WebDriver driver;		
	WebDriverWait Ex;
	Actions build;
	JavascriptExecutor js;
@BeforeTest(groups="SmokeTest0")
public void setup() {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
Ex= new WebDriverWait(driver,10);
  build = new Actions(driver);
 js=(JavascriptExecutor)driver;
}

@Test(priority=0)	
public void actions(){
	driver.get("https://www.facebook.com/");
	WebElement email= driver.findElement(By.id("email"));
	Action series = build.moveToElement(email).click().keyDown(email,Keys.SHIFT).sendKeys(email,"hello").keyUp(email, Keys.SHIFT).build();
	series.perform();
	driver.get("https://demoqa.com/droppable");

	WebElement From= driver.findElement(By.id("draggable"));
	WebElement To= driver.findElement(By.id("droppable"));
	Action series1 = build.dragAndDrop(From, To).build();
	series1.perform();
	Action series2 = build.moveToElement(From).clickAndHold().release(To).build();
	series2.perform();
	
}
	@Test(priority=1)	
	public void alerts() throws InterruptedException{
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Ayisha");
		driver.switchTo().alert().accept();
		
	}
	@Test(priority=2)
	public void frames() {
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame(1); //first child string
		WebElement sampletext=driver.findElement(By.id("sampleHeading"));
		System.out.println(sampletext.getText());
		driver.switchTo().defaultContent(); //comming back to the main window
		driver.switchTo().frame(2); //2nd child int
		WebElement sampletext2=driver.findElement(By.id("sampleHeading"));
		System.out.println(sampletext2.getText());
		driver.switchTo().defaultContent();
		WebElement iframe=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);
		driver.switchTo().defaultContent();
		js.executeScript("window.scrollBy(0, window.innerHeight)");//scroll down
		driver.switchTo().frame(2);
		js.executeScript("window.scrollBy(48,148),'';");//scroll up based on x and y condinate
		js.executeScript("window.scrollBy(48,-148),'';");//scroll up based on x and y condinate
		js.executeScript("window.scrollBy(100,0)");//scroll right based on x cordinate and y condinate=0
		js.executeScript("window.scrollBy(-100,0)");//scroll leftbased on x cordinate and y condinate=0
		driver.switchTo().defaultContent();
		driver.get("https://demoqa.com/elements");
		WebElement checkbox=driver.findElement(By.id("item-1"));
		js.executeScript("arguments[0].scrollIntoView();",checkbox);
	}
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();

	
	
	
	

}	

}
