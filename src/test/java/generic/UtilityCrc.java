package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityCrc 
{
	public static String getdata(String path, String sheetno, int row, int colm)
	{
		String d=null;
		try
		{
			FileInputStream f1=new FileInputStream(path);
			Workbook book=WorkbookFactory.create(f1);
			d=book.getSheet(sheetno).getRow(row).getCell(colm).getStringCellValue();
			
		}
		catch (Exception e) 
		{
		
		}
		return d;
	}

//	public static void getphoto(WebDriver driver, String name)
//	{
//		TakesScreenshot shot=(TakesScreenshot)driver;
//		File src = shot.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./src/screenshots/"+name+".png");
//		try 
//		{
//			FileUtils.copyFile(src, dest);
//		} 
//		catch (IOException e) 
//		{
//
//		}
//	}
}
