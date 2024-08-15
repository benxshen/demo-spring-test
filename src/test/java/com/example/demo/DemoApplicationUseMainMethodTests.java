package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "emo1=^_^"
})
class DemoApplicationUseMainMethodTests {

    @Test
    void contextLoads(@Autowired Environment env) {
        System.out.println("Hello World. Spring env: " + env);
        assertThat(env.getActiveProfiles()).contains("myprofile");
    }

    @Test
    void testConfiguration(@Autowired(required = false) List<String> _myList) {
        assertThat(_myList).isNull();
    }

}
