package com.example.springpractice.test;


import org.springframework.stereotype.Component;


/**
 * 첫번째 방법 @Component를 사용한다. == Bean으로 등록된다 == IOC 컨테이너에 저장된다.
 * 해당 어노테이션을 사용하면 프로그램이 실행되는 시점에 @Component 어노테이션이 달린 모든 클래스 정보를 객체로 만들어서 IOC 컨테이너에 보관
 * 다른 컴포넌트에서 타입을 검사해서 동일한 타입에 대해서 DI를 적용
 * @Service , @Controller , @Repository 모두 @Component를 내부적으로 가지고 있습니다.
 */
@Component
public class TestComponent {

    public TestComponent() {
        System.out.println("Test Component가 생성되었습니다!!");
    }


    public void testPrint() {
        System.out.println("hello world!!");
    }
}
