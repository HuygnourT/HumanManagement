import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import docFileExcel.Book;

public class readQuanLyNhanKhau {
	private static final int COLUMN_INDEX_MANHANKHAU 	= 0;
	private static final int COLUMN_INDEX_HOVATEN     	= 1;
	private static final int COLUMN_INDEX_SOCMND      	= 2;
	private static final int COLUMN_INDEX_QUEQUAN   	= 3;
	private static final int COLUMN_INDEX_NOISINH      	= 4;
	private static final int COLUMN_INDEX_DANTOC      	= 5;
	private static final int COLUMN_INDEX_NGHENGHIEP    = 6;
	private static final int COLUMN_INDEX_NGAYSINH     	= 7;
	private static final int COLUMN_INDEX_GIOITINH      = 8;
	private static final int COLUMN_INDEX_SDT      		= 9;
	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:/Users/Truong Huy/Desktop/demo.xlsx";
		List<Person> persons = readExcel(excelFilePath);
		for (Person person : persons) {
            System.out.println(person.getMaNhanKhau()+" "+person.getHoVaTen()+" "+person.getDanToc());
        }
	}
	public static List<Person> readExcel(String excelFilePath) throws IOException {
        List<Person> listPersons = new ArrayList<>();
 
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));
 
        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);
 
        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);
 
        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }
 
            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();
 
            // Read cells and set value for book object
            Person person = new Person();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                case COLUMN_INDEX_MANHANKHAU:
                	person.setMaNhanKhau((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_HOVATEN:
                	person.setHoVaTen((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_SOCMND :
                	person.setCmnd((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_QUEQUAN:
                	person.setQueQuan((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_DANTOC:
                	person.setDanToc((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_NGHENGHIEP:
                	person.setNgheNghiep((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_NGAYSINH:
                	person.setNgaySinh((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_GIOITINH:
                	person.setGioiTinh((String) getCellValue(cell));
                    break;
                case COLUMN_INDEX_SDT:
                	person.setSdt((String) getCellValue(cell));
                    break;
                default:
                    break;
                }
 
            }
            listPersons.add(person);
        }
 
        workbook.close();
        inputStream.close();
 
        return listPersons;
    }
 
    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }
}


