package Timesheets.Timesheets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Timesheet 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.intacct.com/ia/acct/login.phtml");
		driver.findElementById("company").sendKeys("prokarma");
		driver.findElementById("login").sendKeys("gsathishkumar");
		driver.findElementById("passwd").sendKeys("Kumar@5008");
		driver.findElementById("retbutton").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@class='qx-app-name-arrow fal fa-fw fa-angle-down']").click();
		driver.findElementByXPath("//span[text()='Time & Expenses' and @class='qx-app-name']").click();
		driver.findElementByXPath("//div[@class='qx-row-container qx-menu-item qx-menu-hover' and @data-favname='My timesheets'] /a").click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		WebElement element = driver.findElementByXPath("//input[@name='_obj__TIMESHEETITEMS_0_-_obj__PROJECTID']");
	    driver.executeScript("arguments[0].scrollIntoView()", element);
	    element.click();
		driver.findElementByXPath("//input[@name='_obj__TIMESHEETITEMS_0_-_obj__PROJECTID']/following-sibling::span").click();
		Select drpCountry = new Select(driver.findElement(By.className("combobox-list")));
		drpCountry.selectByVisibleText("PUSA3821--Nike: E2E Automation SAP-WMS (FF)");
		driver.findElementByXPath("//input[@name='_obj__TIMESHEETITEMS_0_-_obj__TASKID']/following-sibling::span").click();
		driver.findElementByXPath("(//select[@class='combobox-list'])[2]");
		Thread.sleep(2000);
		driver.findElementByXPath("//option[text()='17586--Consulting Services']").click();		
		
	for (int i=2;i<=6;i++)
	{
		driver.findElementByXPath("(//tr[@id='tr__obj__TIMESHEETITEMS_0']//td//div[@class='form-group']//input[@class='form-control notes_clear no_grid_min_width right'])["+i+"]").sendKeys("9");
	}
		
    }
    
}
