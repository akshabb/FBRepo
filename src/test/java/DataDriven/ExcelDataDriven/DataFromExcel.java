package DataDriven.ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
	}
	public ArrayList<String> getData(String TestName) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\AKSHAY\\OneDrive\\Desktop\\TestData.xlsx");
		XSSFWorkbook w=new XSSFWorkbook(fis);
		ArrayList<String> a=new ArrayList<String>();
		int NoofSheets=w.getNumberOfSheets();
		for(int i=0;i<NoofSheets;i++)
		{
			if(w.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{
				XSSFSheet SName=w.getSheetAt(i);
				//Identify Testcases column by scanning the entire 1st row
				Iterator<Row> rows=SName.iterator(); //this will have all the rows in rows variable
				Row FirstRow=rows.next();// this will iterate through each row one by one
				Iterator<Cell> cell=FirstRow.cellIterator();//this will have all the cells in cell variable
				int k=0;
				int col=0;
				while(cell.hasNext())
				{
					Cell val=cell.next();
					if(val.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						col=k;
					}
					k++;
				}
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase(TestName))
					{
						Iterator<Cell> c=r.cellIterator();
						while(c.hasNext())
						{
							Cell v=c.next();
							if(v.getCellType()==CellType.STRING)
							{
								a.add(v.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(v.getNumericCellValue()));
								  //OR
								//a.add(String.valueOf(v.getNumericCellValue()));
							}
					}
				}
			}
			
		}
		
	}
		return a;
}
}
