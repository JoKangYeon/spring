package com.study.member.web;


import com.study.exception.BizNotFoundException;
import com.study.member.service.IMemberService;
import com.study.member.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.mail.MessagingException;

@Controller
public class JoinController {

    @Inject
    private IMemberService memberService;

    @RequestMapping("/member/idcheck.wow")
    @ResponseBody
    public boolean idcheck(String memId){
        try {
            memberService.getMember(memId);
            return false;
        } catch (BizNotFoundException e) {
            e.printStackTrace();
            return true;
        }

    }


    @Inject
    MailSendService mailSendService;

    @ResponseBody
    @RequestMapping(value = "/member/emailCheck.wow", produces = "text/plain;charset=UTF-8")
    public String emailCheck(String email) throws MessagingException {
        mailSendService.sendAuthMail(email);
        return "값 전달 잘 됐겠지?";
    }



}
