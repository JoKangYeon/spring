package com.di.step6;

import com.di.step4.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ServiceImpl service1 = context.getBean(ServiceImpl.class);



    }
}
