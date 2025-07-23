package packg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;   





public class Excelutils {

	
	
	public static String getData(String sheetName, int row, int col) {
	    String value = "";
	    try {
	        // ✅ Load file from classpath
	        InputStream fis = Excelutils.class
	                .getClassLoader()
	                .getResourceAsStream("Testdata/Logindata.xlsx"); // ⬅️ Check folder and filename case

	        if (fis == null) {
	            throw new FileNotFoundException("❌ File not found: Testdata/Logindata.xlsx");
	        }
            
            
	        Workbook wb = new XSSFWorkbook(fis);
	        Sheet sheet = wb.getSheet(sheetName);
	        Row r = sheet.getRow(row);
	        if (r != null) {
	            Cell c = (Cell) r.getCell(col);
	            if (c != null) {
	                value = c.toString();
	            }
	        }
	        wb.close();
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
        return value;
    }

	
		
		
		
		
		

	}


