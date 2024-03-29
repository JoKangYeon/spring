package com.study.member.vo;

import com.study.excel.ExcelCoumn;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MemberVO {
    @ExcelCoumn(columnName = "회원 아이디")
    private String memId;        /* 회원아이디 */
    private String memPass;      /* 회원비밀번호 */
    @ExcelCoumn(columnName = "회원 이름")
    private String memName;      /* 회원이름 */
    private String memBir;       /* 회원생년월일 */
    private String memZip;       /* 회원우편번호 */
    private String memAdd1;      /* 회원주소 */
    private String memAdd2;      /* 회원상세주소 */
    private String memHp;        /* 회원전화번호 */
    private String memMail;      /* 회원이메일 */
    @ExcelCoumn(columnName = "회원 직업")
    private String memJob;       /* 회원직업 */
    @ExcelCoumn(columnName = "회원 취미")
    private String memHobby;     /* 회원취미 */
    private int memMileage;      /* 회원마일리지 */
    private String memDelYn;     /* 회원삭제여부 */

    private String memJobNm;
    private String memHobbyNm;

    public MemberVO (){

    }


    public String getMemJobNm() {
        return memJobNm;
    }

    public void setMemJobNm(String memJobNm) {
        this.memJobNm = memJobNm;
    }

    public String getMemHobbyNm() {
        return memHobbyNm;
    }

    public void setMemHobbyNm(String memHobbyNm) {
        this.memHobbyNm = memHobbyNm;
    }

    public MemberVO(String memId, String memPass, String memName, String memBir, String memZip, String memAdd1, String memAdd2, String memHp, String memMail, String memJob, String memHobby, int memMileage, String memDelYn) {
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
        this.memBir = memBir;
        this.memZip = memZip;
        this.memAdd1 = memAdd1;
        this.memAdd2 = memAdd2;
        this.memHp = memHp;
        this.memMail = memMail;
        this.memJob = memJob;
        this.memHobby = memHobby;
        this.memMileage = memMileage;
        this.memDelYn = memDelYn;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemBir() {
        return memBir;
    }

    public void setMemBir(String memBir) {
        this.memBir = memBir;
    }

    public String getMemZip() {
        return memZip;
    }

    public void setMemZip(String memZip) {
        this.memZip = memZip;
    }

    public String getMemAdd1() {
        return memAdd1;
    }

    public void setMemAdd1(String memAdd1) {
        this.memAdd1 = memAdd1;
    }

    public String getMemAdd2() {
        return memAdd2;
    }

    public void setMemAdd2(String memAdd2) {
        this.memAdd2 = memAdd2;
    }

    public String getMemHp() {
        return memHp;
    }

    public void setMemHp(String memHp) {
        this.memHp = memHp;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail;
    }

    public String getMemJob() {
        return memJob;
    }

    public void setMemJob(String memJob) {
        this.memJob = memJob;
    }

    public String getMemHobby() {
        return memHobby;
    }

    public void setMemHobby(String memHobby) {
        this.memHobby = memHobby;
    }

    public int getMemMileage() {
        return memMileage;
    }

    public void setMemMileage(int memMileage) {
        this.memMileage = memMileage;
    }

    public String getMemDelYn() {
        return memDelYn;
    }

    public void setMemDelYn(String memDelYn) {
        this.memDelYn = memDelYn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
