package com.di.step3;

public class ServiceImpl2 implements Iservice {
    private IDao dao;

    public ServiceImpl2(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void getList() {
        // serviceImpl이랑 살짝다른 작업
        dao.getListInDb();

    }
}
