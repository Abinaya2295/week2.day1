package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
		//Launches new browser for every execution
	public static void main(String[] args) {
		// Setup Driver
		WebDriverManager.chromedriver().setup();
		//Launch Browser
		ChromeDriver chrome = new ChromeDriver();
		//Load the URL(get)
		chrome.get("http://leaftaps.com/opentaps/control/main");
		//Maximize the browser
		chrome.manage().window().maximize();
		//Get the title
		String title = chrome.getTitle();
		System.out.println(title);
		//Identify user name and enter the username
		chrome.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//Identify password and enter the password
		chrome.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Login
		chrome.findElement(By.className("decorativeSubmit")).click();
		//Click on CRM/SFA
		chrome.findElement(By.linkText("CRM/SFA")).click();
		//Click on Leads
		chrome.findElement(By.linkText("Leads")).click();
		//Click on Create Lead
		chrome.findElement(By.linkText("Create Lead")).click();
		//Enter mandatory fields
		chrome.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		chrome.findElement(By.id("createLeadForm_firstName")).sendKeys("Abinaya");
		chrome.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		//select Source dropdown
		WebElement srcdropdown = chrome.findElement(By.id("createLeadForm_dataSourceId"));
		Select sd = new Select(srcdropdown);
	//	sd.selectByVisibleText("Employee");
	//	sd.selectByValue("LEAD_EMPLOYEE");
		sd.selectByIndex(4);
		//Click on Create Lead
		chrome.findElement(By.name("submitButton")).click();
		//after creating, print first name
		String text = chrome.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(text);
		
		//Thread.sleep(5000);
		//chrome.close();
	}

}
