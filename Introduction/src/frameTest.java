import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//lessions 89-90

		System.setProperty("webdriver.chrome.driver", "D:\\\\WebDrivers\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
			/*finding the frame by index
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0); */
		
			//finding the frame by WebElement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); // (tagname[class='demo-frame'])
	
		Actions a=new Actions (driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
	}
}
