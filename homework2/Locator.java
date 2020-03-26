package seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.*;
import jxl.read.biff.BiffException;
import java.io.*;

public class Locator {
	public static void main(String[] args) throws BiffException, IOException {
		
		String[] username, password;
	 	Workbook book = Workbook.getWorkbook(new File("Selenium+Lab2020.xls"));
	    //���excel�ļ���sheet��
	    Sheet sheet = book.getSheet("Sheet2");
	        
	    int rows = sheet.getRows();//��
	    int cols = sheet.getColumns();//��
	        
	    System.out.println("��������" + cols);
	    System.out.println("������:" + rows);
	    System.out.println("----------------------------");  
	    
	    username = new String[rows];
	    password = new String[rows];
	    int i=0;
	    //ѭ����ȡ����
	    for( i = 0; i < rows; i++)
	    {
	        username[i] = new String(sheet.getCell(0,i).getContents());
	        password[i] = new String(sheet.getCell(1,i).getContents());
	    }
	    
		String driverPath = System.getProperty("user.dir") + "/resources.driver/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
		driver.get(baseUrl);
		
		int count = 0;
		
	    for (int j = 0; j < username.length; j++) {
	    	WebElement userName = driver.findElement(By.name("user_number"));
			userName.sendKeys(username[j]);
			WebElement passName = driver.findElement(By.name("password"));
			passName.sendKeys(password[j]);
			
			WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
			submitName.click();
			
			WebElement actualAns = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
			String expectedAns = password[j];

			if(actualAns.getText().equals(expectedAns)) {
				count++;
			}else {
				System.out.printf("��%d������", j);
			}

	    }
	    
	    if(count == username.length) {
	    	System.out.println("Success!");
	    }
		
//		driver.close();
	}

}
