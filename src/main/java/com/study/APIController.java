package com.study;

import com.study.exception.BizNotFoundException;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class APIController {

    @Inject
    IFreeBoardService freeBoardService;

    @RequestMapping(value = "/api/string", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String string(){
        return "아무거나 String";
    }

    // produces 종료는 그때 그때 검색

    @RequestMapping("/api/free")
    @ResponseBody
    public FreeBoardVO free(int boNo) throws BizNotFoundException {  // api문서에서는 파라미터로 boNo=? 보내도록하세요
        return freeBoardService.getBoard(boNo);
    }

}
