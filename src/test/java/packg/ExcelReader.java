package packg;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {


		    public List<List<String>> readExcel(String path) 
		    
		    
		    {
		        List<List<String>> steps = new ArrayList<>();
		        
		        
		        try (FileInputStream fis = new FileInputStream(path);
		        		
		        		
		             Workbook wb = new XSSFWorkbook(fis)) 
		        
		        
		        {
		            Sheet sheet = wb.getSheetAt(0);
		            
		            
		            for (int i = 1; i <= sheet.getLastRowNum(); i++)
		            
		            {
		                Row row = sheet.getRow(i);
		                
		                
		                List<String> step = new ArrayList<>();
		                for (int j = 0; j < 6; j++) {
		                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		                    cell.setCellType(CellType.STRING);
		                    step.add(cell.getStringCellValue().trim());
		                }
		                steps.add(step);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return steps;
		
	}

	
		

}

