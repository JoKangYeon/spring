package com.di.step4;

public class DaoMysql implements IDao {
    @Override
    public void getListInDb() {
        System.out.println("mysql에서 List를 얻습니다.");
    }
}
