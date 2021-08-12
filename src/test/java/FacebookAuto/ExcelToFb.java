package FacebookAuto;

import java.util.ArrayList;

import DataDriven.ExcelDataDriven.DataFromExcel;
import DataDriven.ExcelDataDriven.Xls_Reader;

public class ExcelToFb {
	public ArrayList<Object[]> getData()
	{
		ArrayList<Object[]> a=new ArrayList<Object[]>();
		Xls_Reader r=new Xls_Reader("C:\\Users\\AKSHAY\\eclipse-workspace\\ExcelDataDriven\\src\\test\\java\\FacebookAuto\\Facebook_data.xlsx");
		
		
		for(int i=2;i<=r.getRowCount("Sheet1");i++)
		{
			String Fname=r.getCellData("Sheet1", "Firstname", i);
			String Sname=r.getCellData("Sheet1", "Surname", i);
			String Email=r.getCellData("Sheet1", "Email", i);
			String ReEmail=r.getCellData("Sheet1", "ReEmail", i);
			String Pass=r.getCellData("Sheet1", "Pass", i);
			String Date=r.getCellData("Sheet1", "Date", i);
			
			String Month=r.getCellData("Sheet1", "Month", i);
			String Year=r.getCellData("Sheet1", "Year", i);
			String Gender=r.getCellData("Sheet1", "Gender", i);
			String CusPro=r.getCellData("Sheet1", "CustomPronoun", i);
			
			Object ob[]= {Fname,Sname,Email,ReEmail,Pass,Date,Month,Year,Gender,CusPro};
			a.add(ob);
		}
		return a;
		
	}

}
