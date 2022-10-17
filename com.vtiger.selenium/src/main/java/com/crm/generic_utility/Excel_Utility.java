package com.crm.generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * This is the generic method for read data from Excel sheet
	 * @param shName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Santhosh
	 */
	
    public  String getExcellData(String shName,int row,int cell) throws EncryptedDocumentException, IOException 
    {
    //	FileInputStream fis=new FileInputStream("./Book1.xlsx");
    	FileInputStream fis=new FileInputStream(IpathConstant.EXCELFILE_PATH1);
    	Workbook wb = WorkbookFactory.create(fis);
  /*  	 String data = wb.getSheet(shName).getRow(row).getCell(cell).getStringCellValue();
    	 return data;   
    	 */
	DataFormatter format=new DataFormatter();
	return format.formatCellValue(wb.getSheet(shName).getRow(row).getCell(cell));
 
   }  
   } 
	
	


