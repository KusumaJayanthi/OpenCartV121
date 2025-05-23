package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
  //DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	   String path=".\\testData\\DataDrivenTest.xlsx";// taking xl file path from testdata
	   
	   ExcelUtils xlutil=new ExcelUtils(path);// create object for ExcelUtils
	   
	   int totalrows=xlutil.getRowCount("sheet1");
	   int totalcols=xlutil.getCellCount("sheet1", 1);
	   
	String logindata[][]=new String[totalrows][totalcols];
	
	for(int i=1;i<=totalrows;i++)
	{
		for(int j=0;j<totalcols;j++)
		{
			logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
		}
	}
	return logindata;   
		
		
		
		
		
		
		
	}
	
	

}
