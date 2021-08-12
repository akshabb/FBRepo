package FacebookAuto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class FBSteps {
	WebDriver driver;
	
	@Before
	public void Startup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKSHAY\\Downloads\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS );
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	    @Given("^User navigates to the facebook URL \"([^\"]*)\"$")
	    public void user_navigates_to_the_facebook_url_something(String url) throws Throwable {
	    	
	    	driver.navigate().to(url);
	        
	    }
	    
	    @When("^User needs to click on English Language$")
	    public void LangSelection()
	    {
	    	driver.findElement(By.linkText("English (UK)")).click();
	    }

	    @When("^User need to click on create account button$")
	    public void user_need_to_click_on_create_account_button() throws Throwable {
	    	driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
	       
	    }

	    @When("^User needs to land on account details page$")
	    public void user_needs_to_land_on_account_details_page() throws Throwable {
	    System.out.println("Enter the information");
	        
	    }

	    @When("^User needs to enter his (.+) and (.+)$")
	    public void user_needs_to_enter_his_and(String firstname, String surname) throws Throwable {
	    	driver.findElement(By.name("firstname")).clear();
			driver.findElement(By.name("firstname")).sendKeys(firstname);
			driver.findElement(By.name("lastname")).clear();
			driver.findElement(By.name("lastname")).sendKeys(surname);
	        
	    }
	    @When("^User needs to enter his email(.+)$")
	    public void enterEmail(String Email)
	    {
	    	driver.findElement(By.name("reg_email__")).clear();
			driver.findElement(By.name("reg_email__")).sendKeys(Email);
			
	    }
	    
	    @When("^User needs to Reenter his Email(.+)$")
	    public void user_needs_to_reenter_his(String ReEmail) throws Throwable {
	    	driver.findElement(By.name("reg_email_confirmation__")).clear();
			driver.findElement(By.name("reg_email_confirmation__")).sendKeys(ReEmail);
	    	
	    }
	    
	    @When("^User needs to enter his pass(.+)$")
	    public void enterPass(String Pass)
	    {
	    	driver.findElement(By.name("reg_email_confirmation__")).clear();
			driver.findElement(By.name("reg_passwd__")).sendKeys(Pass);
	    }
	    

	   

	    @When("^User needs to select his (.+) and (.+) and (.+)$")
	    public void user_needs_to_select_his_and_and(String day, String month, String year) throws Throwable {
	    	WebElement Day=driver.findElement(By.id("day"));
			Select s= new Select(Day);
			s.selectByVisibleText(day);
			
			WebElement Mon=driver.findElement(By.id("month"));
			Select s1= new Select(Mon);
			s1.selectByVisibleText(month);
			
			WebElement Y=driver.findElement(By.id("year"));
			Select s2= new Select(Y);
			s2.selectByVisibleText(year);
			
	        
	    }
	    @When("^User needs to select his gender(.+)$")
	    public void getGender(String gender)
	    {
	    	List<WebElement> Gen=driver.findElements(By.xpath("//label[@class='_58mt']"));
			for(int i=0;i<Gen.size();i++)
			{
				if(Gen.get(i).getText().equals(gender))
				{
						Gen.get(i).click();
						
				}
			}
	    }

	    @Then("^User should be able to create account$")
	    public void user_should_be_able_to_create_account() throws Throwable {
	    	System.out.println("User successfullt entered all the details");
	        
	    }
	    
	    @After
	    public void tearDown()
	    {
	    	driver.quit();
	    }

	}


