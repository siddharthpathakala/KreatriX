package tdigital.ksight;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("C://Siddhu//App_Automation//KreatriX//ksight//Data1.xlsx");
		//System.out.println(file);
		
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet =wb.getSheet("empD");
		int rows_count = sheet.getLastRowNum()+1;
		int cols_count = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Rows = "+rows_count);
		System.out.println("Cols = "+cols_count);
		
		for(int i=0;i<rows_count;i++)
		{
			XSSFRow current_row = sheet.getRow(i);
			
			for(int j=0;j<cols_count;j++)
			{
				String val =current_row.getCell(j).toString();
				System.out.print(" "+val);
			}
			System.out.println();
		}
		
		
		
		
	}

}
