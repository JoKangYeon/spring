package com.aop.step3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

public class ExetimeAspect {
    // 공통기능

    public Object timeMeasure(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();    // spring에서 설정한 그 메소드
            return result;
        } finally {
            long end = System.nanoTime();
            System.out.println("걸린시간 : " + (end-start));
            // joinPoint를 이용해서 실제 proceed되고있는 메소드와 클래스에 대한 정보얻기
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            System.out.println("실행 클래스 : " + joinPoint.getTarget().getClass().getName());
            System.out.println("실행 메소드 : " + signature.getName());
            System.out.println("실행 메소드 파라미터 : " + Arrays.toString(signature.getParameterNames()));
            System.out.println("실행 메소드 파라미터 타 : " + Arrays.toString(signature.getParameterTypes()));


        }

    }




}
