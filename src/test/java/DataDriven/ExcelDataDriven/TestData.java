package DataDriven.ExcelDataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestData {

	public static void main(String[] args) throws IOException {
		DataFromExcel d=new DataFromExcel();
		ArrayList<String> data=d.getData("Add Profile");
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i));
		}
		

	}

}
