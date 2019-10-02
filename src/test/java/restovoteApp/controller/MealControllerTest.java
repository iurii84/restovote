package restovoteApp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import restovoteApp.model.User;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MealControllerTest extends AbstractControllerTest {

    private final User USER = new User();

    @Test
    void getMealById() {
    }

    @WithMockUser(value = "ROLE_USER")
    @Test
    void getAllMealByRestoID() throws Exception {
        mockMvc.perform(get("/meal/resto/1")
                .with(httpBasic("tanea@gmail.com", "321321321")))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


    }
}