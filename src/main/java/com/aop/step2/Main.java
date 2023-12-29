package com.aop.step2;

import org.springframework.aop.Pointcut;

public class Main {
    public static void main(String[] args) {

        // step1에서 해결못한 recCal도 해결할 수 있는 방법: 프록시(가짜객체)를 이용
        // 어떤 객체를 대신 실행시켜주는 객체

        // 공통기능(시간측정)은 Exe에 맡기고
        // 핵심기능(계산만)만 구현함 ForCal, RecCal
        // 이렇게 공통, 핵심 기능 분리하는 프로그래밍을 AOP(Aspected Oriented P) 관점 지향 프로그래밍



        Calculator forCal = new ForCalculator();
        Calculator recCal = new RecCalculator();
        Calculator forExe = new ExetimeCalculator(forCal);
        Calculator recExe = new ExetimeCalculator(recCal);

        System.out.println(forExe.factorial(5));
        System.out.println(recExe.factorial(5));

     /* AOP의 주요 용어
        Aspect    : 공통기능 정의한 클래스 (보통 우리가 직접만다는 java 파일)
        JoinPoint : 공통기능 적용지점. 메소드호출, 필드값 변경 등. spring에서는 메소드 호출만 지원.
        Pointcut  : Aspect(공통기능)이 모든 메소드에 적용되지는 않겟지...
                    A,B,C메소드 중에서 A에만 적용하고 싶잖아... 그런걸 적용해주는 문법
        Advice    : 메소드 전 후, 전후 + 에러,리턴 등 보통은 (전후)
    */








    }
}
