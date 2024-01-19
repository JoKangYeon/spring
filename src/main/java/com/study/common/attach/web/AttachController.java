package com.study.common.attach.web;

import com.study.common.attach.dao.IAttachDao;
import com.study.common.attach.vo.AttachVO;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class AttachController {

    @Inject
    IAttachDao attachDao;

    //"attach/download?atchNo=12"
    @RequestMapping("attach/download/{atchNo}") //정규 표현식 사용가능
    public void download(@PathVariable("atchNo") int atchNo, HttpServletResponse response) throws IOException {
        // 1. atchNo로 AttachVO 찾기 _ 파일경로, 파일이름, 원래이름, 크기 등등.
        AttachVO attach = attachDao.getAttach(atchNo);
        // 2. attachVO(경로 + 이름)으로 파일 찾기
        String filePath= attach.getAtchPath();
        String fileName = attach.getAtchFileName();
        File file = new File(filePath, fileName);
        // 3. response에서 '다운로드하세요' 라는 header를 세팅하면 끝
        response.setHeader("Content-Type", "application/octet-stream;");
        String originFileName = new String(attach.getAtchOriginalName().getBytes("UTF-8"), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + originFileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setContentLength((int) file.length()); // 진행율
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        // 4. response에 다운로드 할 파일 추가
        FileUtils.copyFile(file, response.getOutputStream());
        response.getOutputStream().close();
    }

    @RequestMapping("attach/showImg.wow")
    public ResponseEntity<byte[]> showIng(String fileName, String filePath) throws IOException {
        File file = new File(filePath, fileName);
        // if (img인지 아닌지 확인)
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", Files.probeContentType(file.toPath()));
        ResponseEntity<byte[]> result = new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

        return result;
    }




}
