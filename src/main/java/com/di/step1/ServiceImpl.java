package com.di.step1;

public class ServiceImpl implements Iservice {
    IDao dao = new DaoOracle();
    @Override
    public void getList() {
        // 여러가지 작업하고
        dao.getListInDb();
        return;


    }
}
