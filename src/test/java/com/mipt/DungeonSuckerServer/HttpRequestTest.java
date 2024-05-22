package com.mipt.DungeonSuckerServer;

import com.mipt.DungeonSuckerServer.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DungeonSuckerRestController.class)
public class HttpRequestTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;
    @Test
    void myOfficeShouldReturnYouAreInMyOffice() throws Exception {
        this.mockMvc.perform(get("/office/myOffice")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("You are in my office!")));
    }

    @Test
    void registerShouldReturnSuccessfulResult() throws Exception {
        this.mockMvc.perform(post("/register").header("PASSWORD", "password").header("LOGIN", "login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Пользователь успешно зарегистрирован")));
    }

    @Test
    void registerShouldReturnBadResult() throws Exception {
        this.mockMvc.perform(post("/register").header("PASSWORD", "").header("LOGIN", "login")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Не введён логин или пароль")));
    }
}
