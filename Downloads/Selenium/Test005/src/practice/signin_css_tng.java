package practice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signin_css_tng {
	WebDriver driver;
@BeforeTest
	public void setup () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
		@Test
		public void Signin() throws InterruptedException {
		//CSS rule 1 tagname[attribute='value']
				driver.findElement(By.cssSelector("a[class='login']")).click();
				System.out.println(driver.findElement(By.cssSelector("a[class='login']")).isDisplayed()+"--Sign in button found");
				
				//Css rule 2 tagname#(id-value)
				driver.findElement(By.cssSelector("input#email_create")).sendKeys("nilufar@yahoo.com");
				System.out.println(driver.findElement(By.cssSelector("input#email_create")).isSelected()+"--Email address is selected");
				
				//Css rule 3 tagname.(class-value)
				driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).click();
				System.out.println(driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).isEnabled()+"--create an account is Clickable");	
				
				//Css rule 5 #(id-value)
				driver.findElement(By.cssSelector("#id_gender1")).click();
				 System.out.println(driver.findElements(By.cssSelector("#id_gender1")).size()+"-- count  ");
				 
		        //Css rule - 6 tagname[attribute*='sub_string_slashunder']
		        driver.findElement(By.cssSelector("input[id*='_gender2']")).click();
		        System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2")).isDisplayed()+"-- Mrs is displayed  ");
		        System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2")).isSelected()+"-- Mrs is selected ");
		        System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2")).isEnabled()+"-- Mrs is Enabled ");
		        System.out.println(driver.findElements(By.cssSelector("input[id*='_gender2")).size()+"-- count  "); 
				 //exp.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='_gender2']")));
				//Css rule 4 .class-value.class-value..... *if multiple value of class with spaces
		        
				//Css rule - 7 tagname[attribute^='start of String']
		        System.out.println(driver.findElement(By.cssSelector("input[id^='custom")).isEnabled()+"-- First name is enabled ");
		        driver.findElement(By.cssSelector("input[id^='custom']")).sendKeys("Nilufar");
		        System.out.println(driver.findElement(By.cssSelector("input[id^='custom")).isSelected()+"-- First name is selected");
		        
				//Css rule - 8 tagname[attribute1='value'][attribute2='value']
		        driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).sendKeys("Yassman");
		        System.out.println(driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).isDisplayed()+"-- lastname is displayed  ");
		        System.out.println(driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).isSelected()+"-- lastname is selected ");
		        
				//Css rule - 9 tag[attribute$=suffix of the string]
		        driver.findElement(By.cssSelector("input[id$='wd']")).sendKeys("12345");
		        
		      //CSS rule 1 tagname[attribute='value']
		        WebElement drpdays=driver.findElement(By.cssSelector("select[id='days']"));
		        drpdays.click();
		        Select Day= new Select(drpdays);
		        Day.selectByValue("10");
		        
		      //Css rule 2 (tagname#id-value)
		        WebElement drpmonth = driver.findElement(By.cssSelector("select#months"));
		        drpmonth.click();
		        Select Month= new Select(drpmonth);
		        Month.selectByVisibleText("January ");
		        System.out.println(driver.findElement(By.cssSelector("select#months")).isDisplayed()+"-- month is displayed");
		      //Css rule 5 #(id_value)
		        WebElement drpyear = driver.findElement(By.cssSelector("#years"));
		        drpyear.click();
		        Select Year= new Select(drpyear);
		        Year.selectByIndex(5);
		        Thread.sleep(5000);
		        System.out.println(driver.findElement(By.cssSelector("#years")).isDisplayed()+"--year is displayed");
		      //Css rule - 8 tagname[attribute1='value'][attribute2='value']
		        driver.findElement(By.cssSelector("input[id='newsletter'][name='newsletter']")).click();
		        System.out.println(driver.findElement(By.cssSelector("input[id='newsletter'][name='newsletter']")).isSelected()+"-- Newsletter is selected");
		        
		      //Css rule - 7 tagname[attribute^='start of String']
		        driver.findElement(By.cssSelector("input[id^='opt']")).click(); 
		        System.out.println(driver.findElement(By.cssSelector("input[id^='opt']")).isSelected()+"-- special offer is selected");
		        
		        //Css rule - 6 tagname[attribute*='sub_string_slashunder']
		        driver.findElement(By.cssSelector(" input[id*='pany']")).sendKeys("IBM"); 
		        System.out.println(driver.findElement(By.cssSelector(" input[id*='pany']")).isDisplayed()+"-- company is displayed");
		      //Css rule 4 .class-value.class-value..... *if multiple value of class with spaces
		      
		  //Css rule - 7 tagname[attribute^='start of String']
		        driver.findElement(By.cssSelector("input[id^='addres']")).sendKeys("9500 Craigs Mill dr"); 
		        System.out.println(driver.findElement(By.cssSelector("input[id^='addres']")).isEnabled()+"-- address is enabled ");
		        
		      //Css rule - 9 tag[attribute$=suffix of the string]
		        driver.findElement(By.cssSelector("input[id$=ty]")).sendKeys("Glen Allen"); 
		        System.out.println(driver.findElement(By.cssSelector("input[id$=ty]")).isDisplayed()+"-- city is displayed");
		        
		        //CSS rule 1 tagname[attribute='value']
		        WebElement drpstates=driver.findElement(By.cssSelector("select[id='id_state']"));
		        drpstates.click();
		        System.out.println(driver.findElements(By.cssSelector("select[id='id_state']")).size()+"-- count  ");
		        Select State= new Select(drpstates);
		        State.selectByVisibleText("Virginia");
		}	        
@AfterTest
public void closethebrowser() throws InterruptedException {
Thread.sleep(5000);
driver.close();
driver.quit();
	}

}
