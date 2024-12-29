package page;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class loginpage extends Base {


	   

	    



	public void enter_valid_username_and_password() {
		WebElement name=driver.findElement(By.xpath("//input[@id='user-name']"));
		WebDriverWait wait= new  WebDriverWait((WebDriver) driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(prop.getProperty("Name"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys(prop.getProperty("Password"));

	}

	public void click_on_login_button() {
		WebElement click = driver.findElement(By.xpath("//input[@id='login-button']"));
		click.click();

	}

	public void user_should_login_and_navigate_to_homepage() {
	assertTrue(driver.findElement(By.xpath("//span[@class='title']")).isDisplayed());
	}

}
