package Qspiders;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Working_With_screenshot_webPage {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/first.png");
		FileHandler.copy(temp, dest);
		
		WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'smartwatch')]"));
		temp=ele.getScreenshotAs(OutputType.FILE);
		dest=new File("./screenshot/watch.png");
		FileHandler.copy(temp, dest);
		
		Thread.sleep(3000);
		driver.quit();

	}

}
