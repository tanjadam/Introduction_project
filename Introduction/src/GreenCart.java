import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCart {

public static void main(String[] args) throws InterruptedException{
	// TODO Auto-generated method stub
	//lessons 69-73, 77-79 BUYING VEGETABLES
	
	System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //immplicit wait
	
	String[] itemsNeeded={"Cucumber", "Brocolli", "Beetroot", "Carrot"};
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	Thread.sleep(5000);
	addItems(driver, itemsNeeded);
	driver.findElement(By.cssSelector("img[alt='Cart']")).click(); //click on the bag after selecting vegetables
	driver.findElement(By.xpath("button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy"); //entering the promo code
	driver.findElement(By.cssSelector("button.promoBtn")).click();
	
	WebDriverWait w=new WebDriverWait(driver,5);  //defining explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[style='color: green;']")));
	System.out.println(driver.findElement(By.cssSelector("span[style='color: green;']")).getText());
	
	}
  
public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		
			for (int i=0; i<products.size(); i++)
			String[] name=products.get(i).getText().split("-");
			String formattedName=name[0].trim();
				//format it to get the actual vegetable name
				//converting array into an array list for an easy search
				//checking if the extracted name is present in the array list

			List itemsNeededList=Arrays.asList(itemsNeeded);

				if (itemsNeededList.contains("formattedName"))
				{
					j++;
						//click on ADD TO CARD
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						if (j==itemsNeeded.length)
						{
							break;
						}
				}
	  	}
	}