package data;

import utilities.Xls_Reader;

public class DataFile {
	

	Xls_Reader rd = new Xls_Reader("C:\\Selenium_WorkSpace\\BasicframeWork\\src\\data\\LoginData.xlsx");
	
	
	public String wrongEmail = rd.getCellData("Sheet1", "data", 2);
	public String wrongPassword = rd.getCellData("Sheet1", "data", 3);
	public String emailWithSpecialChar = rd.getCellData("Sheet1", "data", 4);;
	public String globalErr = rd.getCellData("Sheet1", "data", 5);;
	public String emptyEmailErr = rd.getCellData("Sheet1", "data", 6);
	public String emptyPasswordErr = rd.getCellData("Sheet1", "data", 7);
	public String emailWithSpecCharErr = rd.getCellData("Sheet1", "data", 8);

}
