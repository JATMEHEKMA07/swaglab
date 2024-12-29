package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	static {
		try {
			FileInputStream file = new FileInputStream("Testdata/Testdata.properties");
			prop = new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

public void mousehower(WebElement ele) {
	Actions a = new Actions(driver);
	a.moveToElement(ele).build().perform();
}


public void selectByVisibleText(WebElement ele, String value) {
	Select s = new Select(ele);
	s.selectByVisibleText(value);

}

public void selectByIndex(WebElement ele, int value) {
	Select s = new Select(ele);
	s.selectByIndex(value);

}

public void ExecutorClick(WebElement ele) { 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", ele);
}

public void waitforexpected(WebElement ele, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.visibilityOf(ele));
}

public void waitforelementclick(WebElement ele, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.elementToBeClickable(ele));
}

public void javascriptpop(int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.alertIsPresent());
	Alert a = driver.switchTo().alert();
	a.accept();

}
public void explicitweight(WebElement ele) {
	WebDriverWait  W=new WebDriverWait(driver,Duration.ofSeconds(20));
	W.until(ExpectedConditions.visibilityOf(ele));
	
}
public void location(WebElement ele) {
	
	
}

public void getscreenshot() {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File sourcefile = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(sourcefile, new File("Screenshots/" + System.currentTimeMillis() + ".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void AssertEqualsInteger(int Expected, int Actual) {
		assert(Expected==(Actual));
	}
	
	public void AssertEqualsString(String Expected, String Actual) {
		assert(Expected.equals(Actual));
	}
	
	
	public void PositionOfElement(WebElement ele, int L, int Y) {
		
		         Point P=  ele.getLocation();
		             int Xcoordinate= P.getX();
		             int Ycoordinate=P.getY();
		             
                       AssertEqualsInteger(Xcoordinate, L);
                       AssertEqualsInteger(Ycoordinate, Y);

	}
	
	
	public void SizeOfelements(WebElement ele, int H, int W) {
		
		         Dimension Size= ele.getSize();
		         
		    int Height=Size.getHeight();
		    	AssertEqualsInteger(Height, H);
		    	
		    	int Width=Size.getWidth();
		    //	System.out.println(Width);
		    	AssertEqualsInteger(Width, W);
		   
	}
	
	public void ColorOfElement(WebElement ele, String Requirment, String Expectedd) {
		           String CssValue=ele.getCssValue(Requirment);

		    String Actuall= Color.fromString(CssValue).asHex();
		    
		   AssertEqualsString(Expectedd, Actuall);

		
	}
	
	public void GetTextOfElement(WebElement ele, String Expected) {
		          String Text=  ele.getText();
		          
		        
		          
		          AssertEqualsString(Expected, Text);
	}
}

