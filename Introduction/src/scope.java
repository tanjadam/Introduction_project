import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// lessons 91-94
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\WebDrivers\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //web site doesn't work
		System.out.println(driver.findElements(By.tagName("a")).size()); //finding tittle in the entire site
		
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));  //making the mini driver for entire footer
		System.out.println(footerdriver.findElements(By.id("a")).size()); //finding tittle in footer mini driver
		
		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //making the mini driver for one column in footer section
		System.out.println(columndriver.findElements(By.id("a")).size()); //finding tittle in first column of footer section
		
			for (int i=1; i<columndriver.findElements(By.id("a")).size(); i++)
				{
				columndriver.findElements(By.id("a")).get(i).click();
				}
		}

	}
