package com.aop.step1;

public class ForCalculator implements Calculator{


    @Override
    public long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
