package com.example.springpractice.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration도 @Component를 내부적으로 가지고 있습니다.
@Configuration
public class TestConfig {

    @Bean
    public TestComponent2 testComponent2() {
        // 개발자가 직접 new 키워드를 사용해서 Bean으로 등록합니다.
        // 클래스에 @Component를 붙이는 것과 동일하게 동작합니다.
        return new TestComponent2();
    }

}
