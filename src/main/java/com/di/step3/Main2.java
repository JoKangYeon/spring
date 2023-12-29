package com.di.step3;

public class Main2 {
    public static void main(String[] args) {

        Assembler context = new Assembler();
        Iservice service = context.getService();
        service.getList();
        Iservice service2 = context.getService2();
        service2.getList();


    }
}
