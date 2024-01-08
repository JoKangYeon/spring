package com.study.reply.web;

import com.study.common.vo.PagingVO;
import com.study.exception.BizAccessFailException;
import com.study.exception.BizNotFoundException;
import com.study.reply.service.IReplyService;
import com.study.reply.vo.ReplyVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ReplyController {

    @Inject
    IReplyService replyService;

    @ResponseBody
    @RequestMapping("/reply/replyList")
    public List<ReplyVO> replyList(PagingVO paging, String reCategory, int reParentNo){
//        System.out.println(paging);
//        System.out.println(reCategory);
//        System.out.println(reParentNo);
        return replyService.getReplyListByParent(paging, reCategory, reParentNo);
    }

    @ResponseBody
    @RequestMapping("/reply/replyRegist")
    public void registReply(ReplyVO reply){
        replyService.registReply(reply);
    }

    @ResponseBody
    @RequestMapping("/reply/replyModify")
    public void modifyReply(ReplyVO reply){
        try {
            replyService.modifyReply(reply);
        } catch (BizNotFoundException | BizAccessFailException e) {
            e.printStackTrace();
        }

    }

    @ResponseBody
    @RequestMapping("/reply/replyDelete")
    public void deleteReply(ReplyVO reply){
        try {
            replyService.removeReply(reply);
        } catch (BizNotFoundException | BizAccessFailException e) {
            throw new RuntimeException(e);
        }
    }



}
