package utility;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class BaseClass {
	
//	reusable methods without annotation  and dataproviders 
	
	@DataProvider
	public String[][]  excelRead() throws IOException {
		
		//path 
				String path = System.getProperty("user.dir")+"\\ExcelFiles\\book1.xlsx";
				
				//get file 
				File f = new File(path);
				
				//file to object 
				FileInputStream fi = new FileInputStream(f);
				
				//workbook 
				Workbook wb = new XSSFWorkbook(fi);
				
				//sheet 
				Sheet sheet = wb.getSheet("login");
				
				//row count 
				int rowCount = sheet.getPhysicalNumberOfRows();  //4 
			
				int cellcount = sheet.getRow(0).getPhysicalNumberOfCells(); //2 
				
				String [] [] datas = new String[rowCount-1][cellcount]; //4
				
				//{ {null,null},{null,null},{null,null} }
				
				
				for(int i=1 ;i<rowCount;i++) {  //2<4
					
					Row row = sheet.getRow(i);  //2
					
					for(int j=0 ; j<cellcount;j++) { //0<2
						
						Cell cell = row.getCell(j); //0
						
						DataFormatter format = new DataFormatter();
						String data = format.formatCellValue(cell); //kavi
						
						datas[i-1][j]=data;// datas[1][0]
					}
					
				}
				
				wb.close();
				
				
				return datas;
		
	}
	
	
public static void captureImage() throws AWTException, IOException {
		
		Robot r = new Robot();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rect = new Rectangle(d);
		
		BufferedImage image = r.createScreenCapture(rect);
		
		File f = new File("./screenShot/orangehrm"+System.currentTimeMillis()+".png");
		
		ImageIO.write(image, "png", f);
		
	}
	
	

}
