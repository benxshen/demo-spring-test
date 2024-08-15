package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoMockMvcTests {

    @Test
//    @WithMockUser(roles = "ADMIN")
    @WithMockUser
    void testWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void testWithMockMvc401(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/")).andExpect(status().is(401));
    }

    @Test
    void testWithMockMvcPub(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/pub")).andExpect(status().isOk())
                .andExpect(content().string("Hello Pub"));
    }

}
