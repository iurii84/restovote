package restovoteApp.controller;

import org.junit.jupiter.api.Test;
import restovoteApp.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class MealControllerTest extends AbstractControllerTest {

private final User USER = new User();
    @Test
    void getMealById() {
    }

    @Test
    void getAllMealByRestoID() throws Exception{
        mockMvc.perform(get("/meal/resto/1"))
                .andDo(print());
    }
}