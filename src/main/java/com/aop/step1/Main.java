package com.aop.step1;

public class Main {
    public static void main(String[] args) {

        Calculator forCal = new ForCalculator();
        long start = System.nanoTime();
        long forResult = forCal.factorial(5);
        long end = System.nanoTime();
        System.out.println(forResult);  // 120
        System.out.println("걸린시간 for : " + (end-start));

        Calculator forCal3 = new ForCalculator();
        long start3 = System.nanoTime();
        long forResult3 = forCal.factorial(5);
        long end3 = System.nanoTime();
        System.out.println(forResult);  // 120
        System.out.println("걸린시간 for : " + (end3-start3));

        Calculator recCal = new RecCalculator();
        long start2 = System.nanoTime();
        long recResult = recCal.factorial(5);
        long end2 = System.nanoTime();
        System.out.println(recResult);  // 120
        System.out.println("걸린시간 rec : " + (end2-start2));

        // 시간측정. 외부에서 측정?
        // forCal 할때마다 똑같은 코드 여러번 쓰네 ? => ForCal.factorial()내부에 시간측정하면  코드 여러번 안쓰네
        // 그럼 recCal은 ? 내부에 어떻게 쓰지?




    }


}
