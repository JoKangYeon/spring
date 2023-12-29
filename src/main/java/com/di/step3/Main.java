package com.di.step3;

public class Main {
    public static void main(String[] args) {

        // step2에서 외부가 여러곳일 때 해결 못한 거 => Assembler를 통해서..
        // 변경에 용이하고, 확장이 쉽고
        // 대개 기능위주는 객체가 1개만 있으면 됨. 이런건 Assembler 사용하면 좋음
        // 데이터를 가지는 건 객체가 1개만 있으면 절대 안됨


        // Oracle에서 Mysql로 변경 => 바꿔야할 곳은?

        Assembler context = new Assembler();
        Iservice service = context.getService();
        service.getList();
        Iservice service2 = context.getService2();
        service2.getList();

    }
}
