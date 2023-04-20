package com.ecommerce.mangashop.integrationTests;

import com.ecommerce.mangashop.testConfiguration.UserConfig;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RequiredArgsConstructor
@AutoConfigureMockMvc
@Import(UserConfig.class)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName(value = "/api/v1/auth/login - Can login")
    void canLogin() throws Exception {
        // when
        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"user@email.com\", \"password\": \"password\"}"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName(value = "/api/v1/auth/login - wrong credentials sends bad request")
    void wrongCredentialsCanNotLogin() throws Exception {
        // when
        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"random@email.com\", \"password\": \"random\"}"))
                .andExpect(status().isForbidden());
    }

}
