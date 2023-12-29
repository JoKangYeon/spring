package com.di.step1;

public class DaoOracle implements IDao {
    @Override
    public void getListInDb() {
        System.out.println("Oracle에서 List를 얻습니다");
    }
}
