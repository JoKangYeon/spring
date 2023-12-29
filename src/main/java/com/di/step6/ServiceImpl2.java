package com.di.step6;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ServiceImpl2 implements IService {


    @Inject
    private IDao dao;

//    @Inject 생성자 주입이 조금더 굿
//    public ServiceImpl2(IDao dao) {
//        this.dao = dao;
//    }

    @Override
    public void getList() {
        // serviceImpl이랑 살짝다른 작업
        dao.getListInDb();

    }
}
