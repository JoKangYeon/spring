package com.di.step3;

public class ServiceImpl implements Iservice {
    private IDao dao;


    public ServiceImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void getList() {
        // 여러가지 작업하고
        dao.getListInDb();
        return;
    }
}
