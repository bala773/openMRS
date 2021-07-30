package sourceCode;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilitiesClass {

	WebDriver driver; 
	File destinationFile;
	
	UtilitiesClass(WebDriver driver){
		this.driver = driver;
	}
	
	void takeScreenshot() throws IOException {
		
		TakesScreenshot tScreen = (TakesScreenshot)driver;
		
		
		String folderPath = "C:\\Users\\Bala\\eclipse-workspace\\OpenMRS1\\Screenshots/";
				
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String timeStamp = ((dateFormat.format(new Date()).replace(" ","_")).replace("-", "_")).replace(":","");
		
		System.out.println(timeStamp); // "2021-01-22 10:57:50"
		
		String filename = folderPath+timeStamp+".jpg"; //"D:/Selenium-Java HCL training\\EpatSeleniumMavenProjectNew/Screenshots/2021_01_22_105750.jpg"
		
		File scrFile = tScreen.getScreenshotAs(OutputType.FILE);
		
		destinationFile = new File(filename);
	
		FileUtils.copyFile(scrFile, destinationFile);
		
	}

	
}
