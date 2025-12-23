package application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void serveMeal_ValidTicket_ShouldReturn200() throws Exception {
        mockMvc.perform(post("/tickets/T1/serve")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticketId").value("T1"))
                .andExpect(jsonPath("$.mealName").exists())
                .andExpect(jsonPath("$.price").exists());
    }

    @Test
    void serveMeal_InvalidTicket_ShouldReturn404() throws Exception {
        mockMvc.perform(post("/tickets/INVALID/serve")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value("TICKET_NOT_FOUND"));
    }
}
