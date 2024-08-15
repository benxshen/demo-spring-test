package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DemoApplicationUT {

    @Test
    void hello() {
        assertThat(new DemoApplication().hello()).isEqualTo("Hello World");
    }

}
