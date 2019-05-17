package event;

import console.PersonTamTru;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeQuanLyTamTru {
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
	private static final int COLUMN_INDEX_MATHUONGTRU   = 10;
	private static final int COLUMN_INDEX_SOHOKHAU     	= 11;
	private static final int COLUMN_INDEX_QUANHECHUHO   = 12;
	private static final int COLUMN_INDEX_NOIOTRUOC     = 13;
	private static final int COLUMN_INDEX_NGAYCHUYENDEN = 14;
	private static CellStyle cellStyleFormatNumber = null;
	public static void writeExcel(List<PersonTamTru> persons,String excelFilePath) throws IOException
	{
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet("Quản Lý Tạm Trú");
		
		int rowIndex = 0;
		
		//writeHeader
		writeHeader(sheet,rowIndex);
		
		rowIndex++;
		
		for(PersonTamTru person : persons)
		{
			// Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writePerson(person, row);
            rowIndex++;
		}
		
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
	}
	// Create workbook
	public static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_MANHANKHAU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã Nhân Khẩu");
        
        cell = row.createCell(COLUMN_INDEX_HOVATEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ Và Tên");
        
        cell = row.createCell(COLUMN_INDEX_SOCMND);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số CMND");
 
        cell = row.createCell(COLUMN_INDEX_QUEQUAN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Quê Quán");
 
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Dân Tộc");
        
        cell = row.createCell(COLUMN_INDEX_NGHENGHIEP);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nghề Nghiệp");
        
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày Sinh");
        
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới Tính");
        
        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số Điện Thoại");
        
        cell = row.createCell(COLUMN_INDEX_MATHUONGTRU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã Thường Trú");
        
        cell = row.createCell(COLUMN_INDEX_SOHOKHAU);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số Hộ Khẩu");
        
        cell = row.createCell(COLUMN_INDEX_QUANHECHUHO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Quan Hệ Chủ Hộ");
        
        cell = row.createCell(COLUMN_INDEX_NOIOTRUOC);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Địa Chỉ Cũ");
        
        cell = row.createCell(COLUMN_INDEX_NGAYCHUYENDEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày Chuyển Đến");
    }
    public static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    public static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
    public static void writePerson(PersonTamTru person, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell = row.createCell(COLUMN_INDEX_MANHANKHAU);
        cell.setCellValue(person.getMaNhanKhau());
 
        cell = row.createCell(COLUMN_INDEX_HOVATEN);
        cell.setCellValue(person.getHoVaTen());
 
        cell = row.createCell(COLUMN_INDEX_SOCMND);
        cell.setCellValue(person.getCmnd());
 
        cell = row.createCell(COLUMN_INDEX_QUEQUAN);
        cell.setCellValue(person.getQueQuan());
         
        cell = row.createCell(COLUMN_INDEX_NOISINH);
        cell.setCellValue(person.getNoiSinh());
        
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellValue(person.getDanToc());
        
        cell = row.createCell(COLUMN_INDEX_NGHENGHIEP);
        cell.setCellValue(person.getNgheNghiep());
        
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue(person.getNgaySinh());
        
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue(person.getGioiTinh());
        
        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue(person.getSdt());
        
        cell = row.createCell(COLUMN_INDEX_MATHUONGTRU);
        cell.setCellValue(person.getNoiSinh());
        
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellValue(person.getDanToc());
        
        cell = row.createCell(COLUMN_INDEX_NGHENGHIEP);
        cell.setCellValue(person.getNgheNghiep());
        
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue(person.getNgaySinh());
        
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue(person.getGioiTinh());
        
        cell = row.createCell(COLUMN_INDEX_SDT);
        cell.setCellValue(person.getSdt());
        
        cell = row.createCell(COLUMN_INDEX_MATHUONGTRU);
        cell.setCellValue(person.getMaThuongTru());
        
        cell = row.createCell(COLUMN_INDEX_SOHOKHAU);
        cell.setCellValue(person.getSoHoKhau());
        
        cell = row.createCell(COLUMN_INDEX_QUANHECHUHO);
        cell.setCellValue(person.getQuanHeChuHo());
        
        cell = row.createCell(COLUMN_INDEX_NOIOTRUOC);
        cell.setCellValue(person.getNoiOTruoc());
        
        cell = row.createCell(COLUMN_INDEX_NGAYCHUYENDEN);
        cell.setCellValue(person.getNgayChuyenDen());
        
    }
    public static List<PersonTamTru> getPersons(PersonTamTru[] arrayOfPerson,int n)
    {
    	List<PersonTamTru> listPerson = new ArrayList<>();
    	for(int i = 1 ; i < n+1 ; i++)
    	{
    		listPerson.add(arrayOfPerson[i-1]);
    	}
    	return listPerson;
    }
    public static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    public static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
    public static void main(String[] args) throws IOException {
    	PersonTamTru[] arOfPerson = new PersonTamTru[1];
    	arOfPerson[0].setCmnd("0935");
		String excelFilePath = "C:/Users/Truong Huy/Desktop/test.xlxs";
		List<PersonTamTru> persons = getPersons(arOfPerson,1);
		writeExcel(persons,excelFilePath);
	}
}

