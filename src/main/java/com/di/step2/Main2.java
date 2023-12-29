package com.di.step2;

public class Main2 {
    public static void main(String[] args) {

        // step1과 달리 의존개체를 직접 생성하는게아니라 외부 (main)에서 주입
        // Oracle에서 Mysql로 바꾼다 ==> 외부 1곳만 변경하면됨

        IDao dao = new DaoOracle();


        Iservice service = new ServiceImpl(dao);
        service.getList();

        Iservice service2 = new ServiceImpl2(dao);
        service2.getList();



    }
}
