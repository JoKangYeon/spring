package com.di.step3;

public class DaoOracle implements IDao {
    @Override
    public void getListInDb() {
        System.out.println("Oracle에서 List를 얻습니다");
    }
}
