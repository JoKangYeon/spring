package com.aop.step2;

public class ExetimeCalculator implements Calculator{

    private  Calculator delegate;

    public ExetimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(int num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.println("걸린시간 : " + (end-start));
        return result;
    }
}
