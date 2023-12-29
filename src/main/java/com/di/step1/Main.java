package com.di.step1;

public class Main {
    public static void main(String[] args) {
        // DI (Dependency Inject) 의존 주입
        // Service 객체는 내부에서 Dao객체의 메소드를 실행
        // Service가 Dao에 의존

        // 상황1. Oracle대신에 Mysql 사용하기로 했습니다. ==> 고쳐야될 곳이 몇개 ?
        // 의존객체를 직접 만들면 고쳐야할 곳이 2개



        Iservice service = new ServiceImpl();
        service.getList();

        Iservice service2 = new ServiceImpl2();
        service2.getList();



    }
}
