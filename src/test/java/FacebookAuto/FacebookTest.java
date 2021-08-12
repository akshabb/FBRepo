package FacebookAuto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookTest {
	WebDriver driver;
	@BeforeMethod
	public void Launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKSHAY\\Downloads\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS );
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		driver.findElement(By.linkText("English (UK)")).click();
	}
	
	@DataProvider
	public Iterator<Object[]> get()
	{
		ExcelToFb f=new ExcelToFb();
		ArrayList<Object[]> data=f.getData();
		return data.iterator();
	}
	
	@Test(dataProvider = "get")
	public void CreateAcc(String Fname,String Sname,String Email,String ReEmail, String Pass,String Date,String Month, String Year,String gender,String CusPro) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(Fname);
		
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(Sname);
		
		driver.findElement(By.name("reg_email__")).clear();
		driver.findElement(By.name("reg_email__")).sendKeys(Email);
		
		driver.findElement(By.name("reg_email_confirmation__")).clear();
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(ReEmail);
		
		driver.findElement(By.name("reg_email_confirmation__")).clear();
		driver.findElement(By.name("reg_passwd__")).sendKeys(Pass);
		
		WebElement Day=driver.findElement(By.id("day"));
		Select s= new Select(Day);
		
			
		s.selectByVisibleText(Date.split("\\.")[0]); // here before "." operator, escape sequence(\\) is used because "." is not a common delimited(unlike comma,whitespace)to join string.
		//So in order to split String using ".", here we used "\\" before dot operator.
		
		
		WebElement Mon=driver.findElement(By.id("month"));
		Select s1= new Select(Mon);
		s1.selectByVisibleText(Month);
		
		WebElement Y=driver.findElement(By.id("year"));
		Select s2= new Select(Y);

		s2.selectByVisibleText(Year.split("\\.")[0]);
		
		
		List<WebElement> Gen=driver.findElements(By.xpath("//label[@class='_58mt']"));
		for(int i=0;i<Gen.size();i++)
		{
			if(Gen.get(i).getText().equals(gender))
			{
					Gen.get(i).click();
					if(Gen.get(i).getText().equals("Custom"))
						{
						WebElement c=driver.findElement(By.name("preferred_pronoun"));
						Select s3=new Select(c);
						List<WebElement> L=s3.getOptions();
						for(int j=0;j<L.size();j++)
						{
							if(L.get(j).getText().contains(CusPro))
							{
								L.get(j).click();
								Thread.sleep(2000);
							}
						}
						
						}
			}
		}
		
		
		
	}
	
@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
