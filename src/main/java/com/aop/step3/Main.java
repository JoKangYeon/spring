package com.aop.step3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop/step3.xml");
        ForCalculator forCal = context.getBean(ForCalculator.class);
        long result = forCal.factorial(5);
        System.out.println("결과 : " + result);

        RecCalculator recCal = context.getBean(RecCalculator.class);
        long result2 = recCal.factorial(5);
        System.out.println("결과 : " + result2);








    }
}
