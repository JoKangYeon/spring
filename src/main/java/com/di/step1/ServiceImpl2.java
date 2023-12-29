package com.di.step1;

public class ServiceImpl2 implements Iservice {
    IDao dao = new DaoOracle();
    @Override
    public void getList() {
        // serviceImpl이랑 살짝다른 작업
        dao.getListInDb();

    }
}
