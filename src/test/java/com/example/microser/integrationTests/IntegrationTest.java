package com.example.microser.integrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Test
    void contextLoad() {
    }

    @Test
    @DisplayName("http://localhost:9090/find")
    public void shouldReturnData() {
        fail();
    }

    @Test
    @DisplayName("http://localhost:9090/findBy")
    public void shouldReturnData2() {
        fail();
    }
}
