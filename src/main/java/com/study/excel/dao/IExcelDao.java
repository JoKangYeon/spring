package com.study.excel.dao;

import com.study.free.vo.FreeBoardVO;
import com.study.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IExcelDao {

    public List<FreeBoardVO> getFreeList();
    public  List<MemberVO> getMemberList();
}
