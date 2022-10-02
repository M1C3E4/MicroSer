package com.example.microser.integrationTests;

import com.example.microser.entity.OfferEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private  MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoad() {
    }

    @Test
    @DisplayName("http://localhost:9090/findById/{id} -> 200")
    public void shouldReturnDataById()throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/findById/1")
                .contentType("application/json")
                        .param("id", "1L"))
                .andDo(print())
                .andExpect(status().isOk());
        OfferEntity expected = new OfferEntity(1L, "JavaDeveloper", 12000);
        String jsonAsString = resultActions.andReturn().getResponse().getContentAsString();
        OfferEntity offerEntity = objectMapper.readValue(jsonAsString, OfferEntity.class);
        assertEquals(expected.getId(), offerEntity.getId());
        assertEquals(expected.getTitle(), offerEntity.getTitle());
        assertEquals(expected.getSalary(), offerEntity.getSalary());
    }

    @Test
    @DisplayName("http://localhost:9090/findByTitle/{title} -> 200")
    public void shouldReturnDataByTitle()throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/findByTitle/JavaDeveloper")
                .contentType("application/json")
                .param("title", "JavaDeveloper"))
                .andDo(print())
                .andExpect(status().isOk());
        OfferEntity expected = new OfferEntity(2L, "JavaDeveloper", 9000);
        String jsonAsString = resultActions.andReturn().getResponse().getContentAsString();
        OfferEntity offerEntity = objectMapper.readValue(jsonAsString, OfferEntity.class);
        assertEquals(expected.getId(), offerEntity.getId());
        assertEquals(expected.getTitle(), offerEntity.getTitle());
        assertEquals(expected.getSalary(), offerEntity.getSalary());
    }
}
