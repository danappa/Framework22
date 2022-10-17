package com.crm.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibCls {
	
	public String getCommonData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/crmcommondata.property");
		Properties p= new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
	
	public String getExcelData(String shName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./data/crmtestscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(shName).getRow(row).getCell(cell).toString();
		return data;
	}

}
