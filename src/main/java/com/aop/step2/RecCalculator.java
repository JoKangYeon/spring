package com.aop.step2;

public class RecCalculator implements Calculator {

    @Override
    public long factorial(int num) {

        return  num > 1 ? num*factorial(num-1) : 1;


    }
}
