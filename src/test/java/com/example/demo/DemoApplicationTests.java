package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import jakarta.annotation.Resource;

//@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "emo1=^_^"
})
class DemoApplicationTests {

    @Value("${emo1}")
    private String propEmo1;

    @Resource
    private List<String> myList;

    @TestConfiguration
    static class Config {
        @Bean
        public List<String> myList() {
            return List.of("a", "b", "c");
        }
    }

    @Test
    void contextLoads(@Autowired Environment env) {
        System.out.println("Hello World. Spring env: " + env);
        assertThat(env.getActiveProfiles()).contains("test");
    }

    @Test
    void testConfiguration(@Autowired List<String> _myList) {
        assertThat(_myList).containsExactly("a", "b", "c").isSameAs(myList);
    }

    @Test
    void testProperties() {
        assertThat(propEmo1).isEqualTo("^_^");
    }

}
