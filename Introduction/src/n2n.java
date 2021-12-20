import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class n2n {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//lessons 45-59, buying plane ticket
		
		System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
	//cekiranje One way opcije
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_0")).click();
		
	//cekiranje pocetne i krajnje destinacije
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("a[@value='MAA']")).click();	
		
	//biranje odlaznog datuma
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
	//da proverimo da li je povratni datum moguce izabrati
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
			{
			System.out.println("It's disabled.");
			Assert.assertTrue(true);
			}
				
		else
			{
				Assert.assertTrue(false);
			}
	
		//cekiranje SeniorCitizen polja
		driver.findElement(By.cssSelector("input[id*='Content_SeniorCitizen']")).click();
		
		//cekiranje 5-oro putnika
		driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(2000);
		for (int i=1; i<5; i++)
			{
				driver.findElement(By.id("hrefIncAdt")).click();
			}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adults");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());	
		
		//Search dugme
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		
	}
}
