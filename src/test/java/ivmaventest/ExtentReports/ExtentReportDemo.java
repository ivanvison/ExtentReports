package ivmaventest.ExtentReports;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent = new ExtentReports();;
		
	@BeforeTest
	public void config() {
		//ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("IV MVN Automation Test");
		reporter.config().setDocumentTitle("IV MVN Automation Test");
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ivan");
		

	}
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ivan\\Desktop\\QA Path\\Projects-Eclipse\\ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.bettyperez.net");
		System.out.println(driver.getTitle());
		test.fail("Results do not match");
		
		driver.quit();
		extent.flush();
	}
	
	@Test
	public void SecondaryDemo() {
		Assert.assertTrue(false);

	}

}


