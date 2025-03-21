package GuviSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTask {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		
		driver.switchTo().frame(driver.findElement(By.xpath(".//frame[@name='frame-top']")));
		
		int numberOfTopFrames = driver.findElements(By.tagName("frame")).size();
		System.out.println("Number of elements in top frame is "+numberOfTopFrames);
		
		driver.switchTo().frame(driver.findElement(By.xpath(".//frame[@name='frame-left']")));
		System.out.println("Text in Left frame is "+ getTextInframe());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println("Text in Middle frame is "+ getTextInframe());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		System.out.println("Text in Right frame is "+ getTextInframe());
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		System.out.println("Text in Bottom frame is "+ getTextInframe());
		
		driver.switchTo().defaultContent();
//		driver.switchTo().frame("frame-top");
		System.out.println("Title of page is "+ driver.getTitle());
	}
	
	public static String getTextInframe() {
		String FrameText = driver.findElement(By.xpath("//html/head/following-sibling::body")).getText();
		return FrameText;
	}

}
