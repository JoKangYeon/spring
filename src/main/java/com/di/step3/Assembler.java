package com.di.step3;

public class Assembler {
    private IDao dao = new DaoOracle();
    private Iservice service;
    private Iservice service2;

    public Assembler() {
        this.dao = new DaoOracle();
        this.service = new ServiceImpl(dao);
        this.service2 = new ServiceImpl2(dao);
    }

    public IDao getDao() {
        return dao;
    }

    public Iservice getService() {
        return service;
    }

    public Iservice getService2() {
        return service2;
    }
}
