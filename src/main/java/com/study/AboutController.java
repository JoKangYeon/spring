package com.study;

import com.study.code.ParentCode;
import com.study.code.service.ICommCodeService;
import com.study.code.vo.CodeVO;
import com.study.common.vo.PagingVO;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;
import com.study.member.service.IMemberService;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;


@Controller
public class AboutController {

    @RequestMapping("/about/aboutHome")
    public String aboutHome(){

        return "about/aboutHome";
    }

    @Inject
    ICommCodeService codeService;

    @Inject
    IMemberService memberService;

    @Inject
    IFreeBoardService freeBoardService;



    @RequestMapping("/about/freeList")
    public String freeList(Model model, @ModelAttribute("paging") PagingVO paging, @ModelAttribute("search") FreeBoardSearchVO search) {

        List<FreeBoardVO> freeBoardList = freeBoardService.getBoardList(paging, search);
        List<CodeVO> cateList = codeService.getCodeListByParent(ParentCode.BC00.name());

        model.addAttribute("freeBoardList", freeBoardList);
        model.addAttribute("cateList", cateList);

        return "about/freeList";
    }

    @RequestMapping("/about/memberList")
    public String memberList(Model model, PagingVO paging, MemberSearchVO search) { //  @ModelAttribute("search") 이런식으로 파라미터로 오는건 처리해도됨
        List<CodeVO> hobbyList = codeService.getCodeListByParent(ParentCode.HB00.name());
        List<CodeVO> jobList = codeService.getCodeListByParent(ParentCode.JB00.name());
        List<MemberVO> memberList = memberService.getMemberList(paging, search);

        model.addAttribute("paging", paging);
        model.addAttribute("search", search);
        model.addAttribute("hobbyList", hobbyList);
        model.addAttribute("jobList", jobList);
        model.addAttribute("memberList", memberList);

        return "about/memberList";
    }



}
