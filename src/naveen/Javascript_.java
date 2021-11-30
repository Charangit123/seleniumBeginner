package naveen;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_ {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("charanraj");
		driver.findElement(By.id("passContainer")).sendKeys("charanraj");
		WebElement elemnt = driver.findElement(By.name("login"));
		highlight(elemnt, driver);
		drawborder(elemnt, driver);
	}

	public static void highlight(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String backcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changColor("rgb(0,200,0)", element, driver);
			changColor(backcolor, element, driver);
		}
	}

	public static void changColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}
public static void drawborder(WebElement element,WebDriver driver) {
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	js.executeScript("arguments[0].style.border='3px solid red'", element);
}
}
