package com.study.excel.service;



import com.study.excel.ExcelCoumn;
import com.study.excel.dao.IExcelDao;
import com.study.free.vo.FreeBoardVO;
import com.study.member.vo.MemberVO;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.List;

@Service
public class ExcelService {

    @Inject
    IExcelDao excelDao;


    public XSSFWorkbook getFreeExcel(){
        List<FreeBoardVO> freeList = excelDao.getFreeList();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("free");
        //필드 이름
        XSSFRow row = sheet.createRow(0);
        int cellNum = 0;
        XSSFCell cell = row.createCell(cellNum++);
        cell.setCellValue("글 번호");
        cell = row.createCell(cellNum++);
        cell.setCellValue("글 제목");
        cell = row.createCell(cellNum++);
        cell.setCellValue("글 분류");
        cell = row.createCell(cellNum++);
        cell.setCellValue("글 작성자");

        for (int i = 0; i < freeList.size(); i++) {
            XSSFRow dataRow = sheet.createRow(i + 1);
            int dataCellNum = 0;
            FreeBoardVO freeBoard = freeList.get(i);

            dataRow.createCell(dataCellNum++).setCellValue(freeBoard.getBoNo());
            dataRow.createCell(dataCellNum++).setCellValue(freeBoard.getBoTitle());
            dataRow.createCell(dataCellNum++).setCellValue(freeBoard.getBoCategory());
            dataRow.createCell(dataCellNum++).setCellValue(freeBoard.getBoWriter());

        }
        return wb;

    }

    public List<FreeBoardVO> getFreeList(){
        return excelDao.getFreeList();
    }

    public List<MemberVO> getMemberList(){
        return excelDao.getMemberList();
    }

    public XSSFWorkbook getAnyExcel(Class<?> clazz, String sheetName, List<?> list) throws IllegalAccessException {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet(sheetName);

        //columName
        XSSFRow columnRow = sheet.createRow(0);
        int excelColumnCellNum = 0;
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {   //cell  cell   cell
            ExcelCoumn excelCoumn = fields[i].getAnnotation(ExcelCoumn.class);
            if(excelCoumn != null){ // @ExcelCoumn이 붙은 거에 대해서만 cell 생성
                XSSFCell cell = columnRow.createCell(excelColumnCellNum++);
                cell.setCellValue(excelCoumn.columnName());

            }
        }

        //Body
        for (int i = 0; i < list.size(); i++) { // 데이터 list 순회
            int dataColumncellNum = 0;
            XSSFRow row = sheet.createRow(i+1);
            for(int j = 0; j < fields.length; j++) {// vo 필드 순회
                ExcelCoumn excelCoumn= fields[j].getAnnotation(ExcelCoumn.class);
                if(excelCoumn != null){ //@Excelcoumn이 붙은 거에 대해서만 cell 생성
                    fields[j]. setAccessible(true);

                    XSSFCell cell = row.createCell(dataColumncellNum++);
                    // list.get(i). field데이터
                    Object o = fields[j].get(list.get(i));  // list(0) FreeBoardVO
                    if(o == null) cell.setCellValue("null");
                    else cell.setCellValue(o.toString());
                }
            }
        }
        return wb;

    }


}
