package sourceCode;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest1 {
	WebDriver driver;
	ActionsEx actions1;
	Method[] allMethods;

	@Test
	public void test1() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		System.out.println("Hello Test Ng");
		actions1 = new ActionsEx(driver);
		allMethods = ActionsEx.class.getMethods();
		ExcelUtilities excelObj = new ExcelUtilities();

		String propFilePath = "C:\\Users\\Bala\\Desktop\\srmxl.xlsx";
		String moduleSheetName = "MODULES_SHEET";

		String tcSheetName = "TC_SHEET";

		String tsSheetName = "TEST_STEPS_SHEET";

		Map<String, List<String>> allData = excelObj.readDataFromExcel(propFilePath, moduleSheetName, tcSheetName,
				tsSheetName);

		System.out.println(allData.get("Keywords"));
		System.out.println(allData.get("TestData"));
		List<String> allKeyWords = allData.get("Keywords");
		List<String> allTestData = allData.get("TestData");
		
		for(int i=0; i<allKeyWords.size();i++){
			String eachKeyword = allKeyWords.get(i);
			String[] testData2 = allTestData.get(i).split("~");
			List<Object> objList = new ArrayList<Object>();
			for(String testdata1:testData2){
				//
				objList.add(testdata1);
			}
			
			Object[] param = new String[objList.size()];
			param = objList.toArray(param);
			executeTest(eachKeyword, param);
		}
	}

	public void executeTest(String keyword, Object[] params) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		for(Method m1:allMethods){			
			if(m1.getName().equals(keyword)){				
				m1.invoke(actions1, params);
			}
		}
		
	}

	
}
