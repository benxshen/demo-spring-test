package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DemoTestRestTemplatePublicPageTests {

    @Test
    void responsePublicPageOk(@Autowired TestRestTemplate restTemplate) {
        String body = restTemplate.getForObject("/pub", String.class);
        assertThat(body).isEqualTo("Hello Pub");
    }

    @Test
    void response401(@Autowired TestRestTemplate restTemplate) {
        ResponseEntity<String> res = restTemplate.getForEntity("/", String.class);
        assertThat(res.getStatusCode().value()).isEqualTo(401);
    }
}
