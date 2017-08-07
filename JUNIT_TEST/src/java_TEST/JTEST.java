package java_TEST;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JTEST extends Common {
	
//	@BeforeClass
//	public static void test_BeforeClass(){
//		System.out.println("BeforeClass");
//		//fail("Not yet implemented");
//	}
	
	private WebDriver webDriver;
	
	@Before
	public void test_Before() {
		System.out.println("Before");
		
		webDriver = new ChromeDriver();
		//fail("Not yet implemented");
	}
	
	@Test
	public void test() throws InterruptedException {
		System.out.println("Test");
		
		String string;
		
		webDriver.navigate().to("http://www.qa.com");
		System.out.println("\t- "+webDriver.getCurrentUrl());
		
		// Open Menu
		string= "#header > div.header-navbar > a.action-menu";
		webDriver.findElement(By.cssSelector(string)).click();
		
		// Open Courses section.
		Sleep(500); // wait for menu UI
		string= "#menu > div.navigation-links > div:nth-child(2) > div.accordion-heading > div > a.accordion-trigger > i";
		webDriver.findElement(By.cssSelector(string)).click();
		
		// Open training courses
		string= "#header > div.header-navbar > a.action-menu";
		webDriver.findElement(By.cssSelector("#accordion-header-1 > ul > li > div.menu-banner.section-style-a > div > p > a > span")).click();
		
		// Open Agile
		Sleep(500);
		string= "#course-lists > div.layout > article:nth-child(1) > div > ul > li:nth-child(1) > a";
		webDriver.findElement(By.cssSelector(string)).click();
		//fail("Not yet implemented"); // not applicable
	}
	
	@After
	public void test_after() {
		System.out.println("After");
		
		// Find out if title of page has been successfully spotted.
		String string = "#at-a-glance > div:nth-child(1) > header > h1";
		if(webDriver.findElement(By.cssSelector(string)).isDisplayed()){
			System.out.println("\t- Test success!");
		}
		else{
			fail("Test failed"); // fail our test if this does not occur.
		}
		
		// Close Chrome with delay
		Sleep(1000);
		System.out.print("Closing Chrome");
		printDelayed("....", 800);
		webDriver.quit();
		
		
		//fail("Not yet implemented");
	}
	
//	@AfterClass
//	public static void test_afterClass(){
//		System.out.println("AfterClass");
//		//fail("Not yet implemented");
//	}
	
}
