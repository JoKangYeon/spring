package com.study.excel.web;

import com.study.excel.service.ExcelService;
import com.study.free.vo.FreeBoardVO;
import com.study.member.vo.MemberVO;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ExcelController {

    @Inject
    ExcelService excelService;

    @RequestMapping("/excel/test")
    public void excelTest(HttpServletResponse response) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();

        // excel 꾸미기    꾸미기 pot setColor
        XSSFSheet sheet = wb.createSheet("test");
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < 10; i++) {
            XSSFCell cell= row.createCell(i);
            cell.setCellValue("뉴진스" + i);
        }

        row = sheet.createRow(1);
        for (int i = 0; i < 10; i++) {
            XSSFCell cell= row.createCell(i);
            cell.setCellValue("아이브" + i);
        }

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=excel.xlsx");
        wb.write(response.getOutputStream());
    }


//    @RequestMapping("/excel/freeList")
//    public void excelFreeList(HttpServletResponse response) throws  IOException{
//        // free에서 데이터 가지고오고 excela만들고 해야되네
//        XSSFWorkbook freeExcelWb = excelService.getFreeExcel();
//        response.setContentType("ms-vnd/excel");
//        response.setHeader("Content-Disposition", "attachment;filename=excel.xlsx");
//        freeExcelWb.write(response.getOutputStream());
//    }

    @RequestMapping("/excel/freeList")
    public void excel(HttpServletResponse response ) throws IOException, IllegalAccessException {
        List<FreeBoardVO> freeList = excelService.getFreeList();
        XSSFWorkbook freeExcelWb = excelService.getAnyExcel(FreeBoardVO.class, "free", freeList);

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=excel.xlsx");
        freeExcelWb.write(response.getOutputStream());

    }

    @RequestMapping("/excel/memberList")
    public void excelMemberList(HttpServletResponse response ) throws IOException, IllegalAccessException {
        List<MemberVO> memberList = excelService.getMemberList();
        XSSFWorkbook memberWb = excelService.getAnyExcel(MemberVO.class, "member", memberList);

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=excel.xlsx");
        memberWb.write(response.getOutputStream());

    }


}
