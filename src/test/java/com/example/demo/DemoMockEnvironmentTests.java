package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.mock.env.MockEnvironment;

public class DemoMockEnvironmentTests {

    /**
     * TestPropertyValues lets you quickly add properties to a ConfigurableEnvironment or ConfigurableApplicationContext.
     *
     * @see <a href="https://docs.spring.io/spring-boot/reference/testing/test-utilities.html#testing.utilities.test-property-values">TestPropertyValues</a>
     */
    @Test
    void testPropertySources() {
        MockEnvironment environment = new MockEnvironment();
        TestPropertyValues.of("org=Spring", "name=Boot").applyTo(environment);
        assertThat(environment.getProperty("name")).isEqualTo("Boot");
    }

}
