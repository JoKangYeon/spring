package com.di.step5;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {
    private IDao dao;


    public ServiceImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void getList() {
        // 여러 가지 작업하고
        dao.getListInDb();
        return;
    }
}
