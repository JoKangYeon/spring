package com.di.step4;

public class ServiceImpl implements IService {
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
