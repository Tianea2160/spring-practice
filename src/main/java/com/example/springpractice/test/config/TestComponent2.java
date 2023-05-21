package com.example.springpractice.test.config;


/*
해당 클래스는 @Component 어노테이션을 사용하지 않고 @Bean으로 등록해보겠습니다.
 */
public class TestComponent2 {
    public TestComponent2() {
        System.out.println("Test Component2가 생성되었습니다.");
    }
}
