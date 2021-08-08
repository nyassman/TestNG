package practice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Signin_tng {
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

@Test(priority=0,groups={"SmokeTest1"})	
public void openurl(){
	driver.get("http://automationpractice.com/index.php");
}
@Test(priority=1,groups={"SmokeTest2","FunctionalTest1"})
public void signin() {
driver.findElement(By.xpath("//a[@class='login']")).click();
String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account";
String ActualURL=driver.getCurrentUrl();
Assert.assertEquals(ActualURL, ExpectedURL);
System.out.println("Assert passed");
}
@Test(priority=2,invocationCount=3,groups={"Regression", "FunctionalTest2"})
public void enteremail() {
driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']")).sendKeys("nyassman@yahoo.com");
String ExpectedForm="create-account_form";
String ActualForm=driver.findElement(By.id("create-account_form")).getAttribute("id");
Assert.assertEquals(ActualForm, ExpectedForm);
System.out.println("Form was found");
driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']")).clear();
driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']")).sendKeys("nyassman@yahoo.com");
}
@Test(priority=3,dependsOnMethods= {"enteremail"},groups={"FunctionalTest3"})
public void clicksubmit() {
WebElement SubmitCreate=driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]"));
SubmitCreate.click();
Assert.assertEquals(true, SubmitCreate.isEnabled());
System.out.println("Submit Create button enable");

}
@Test(priority=4,dependsOnMethods= {"clicksubmit"},groups={"FunctionalTest4"})
public void personalinfo() {
	
	String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	Ex.until(ExpectedConditions.urlToBe(ExpectedURL));
	String ExpectedForm="account-creation_form";
	String ActualForm=driver.findElement(By.id("account-creation_form")).getAttribute("id");
	Assert.assertEquals(ActualForm, ExpectedForm);
	System.out.println("Form was found");
}
@Test(priority=5,groups={"FunctionalTest5"})
public void selectdays() {

	WebElement drpdays=driver.findElement(By.id("days"));
	//Ex.until(ExpectedConditions.elementToBeClickable(drpdays));
	drpdays.click();
	Select Days = new Select (drpdays);
	Days.selectByVisibleText("5  ");
	String Option=Days.getFirstSelectedOption().getText();
	Assert.assertEquals("5  ",Option);
}
@Test (priority=6)
public void company() {
WebElement company= driver.findElement(By.id("company"));
company.sendKeys("ABC Co");
String Expected="ABC Co";
String Actual= driver.findElement(By.id("company")).getAttribute("value");
Assert.assertEquals(Actual, Expected);
System.out.println(Actual);

}
@Test (priority=7)
public void mobilephone() {

WebElement mobilephone=driver.findElement(By.id("phone_mobile"));
Assert.assertEquals(true, mobilephone.isDisplayed());
System.out.println("---- isDisplayed Assertion Passed");
mobilephone.sendKeys("703-000-000");
Assert.assertEquals(true, mobilephone.isEnabled());
System.out.println("---- isEnabled Assertion Passed");
Assert.assertEquals(false, mobilephone.isSelected());

System.out.println("---- isSelected Assertion Passed");
String Expectedvalue="703-000-000";
String Actualvalue=driver.findElement(By.id("phone_mobile")).getAttribute("value");
Assert.assertEquals(Actualvalue, Expectedvalue);
System.out.println(Actualvalue+ "----Assertion Passed");
int mobilenumber= driver.findElements(By.id("phone_mobile")).size();
	if (mobilenumber==0)//we can use 1
	{
	System.out.println("----Mobilenumber is verified ");
	}
	else if (mobilenumber==1) {
		System.out.println("Mobile Number Duplicate Found");
	}
	
	
	
	else
	{
		System.out.println("----Mobilenumber is not verified ");
	}
	
}

@AfterTest
public void close() {
	driver.close();
}
}

