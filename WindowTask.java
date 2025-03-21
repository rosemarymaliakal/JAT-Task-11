package GuviSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		Thread.sleep(5000);
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
			
			String myText = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
			System.out.println("Text on new window is "+myText);
				
			driver.close();
				
			Thread.sleep(5000);
			driver.switchTo().window(mainWindow);
			
			String activeWindow = driver.getWindowHandle();
			
			if (activeWindow.equals(mainWindow)) {
				System.out.println("Original window is active");
			}
			else {
				System.out.println("Original window is not active");
			}
			
			driver.quit();
			
		}
		

	}


