package com.di.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // context(객체들을 가지고있는) 객체를 통해서 지원해준다
        // 생성할 때 xml이나 .java파일을 읽고 읽은 파일에 맞추어서 필요한 객체들을 생성
        ApplicationContext context = new GenericXmlApplicationContext("di/step5.xml");

        ServiceImpl serviceImpl1 = context.getBean(ServiceImpl.class);
        serviceImpl1.getList();
        ServiceImpl2 serviceImpl2 = context.getBean(ServiceImpl2.class);
        serviceImpl2.getList();

    }
}
