package restovote.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import restovote.model.User;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MealControllerTest extends AbstractControllerTest {

    private final User USER = new User();
    private static JSONObject jsonObject = new JSONObject();

    static {

        jsonObject.put("id", 1);
        jsonObject.put("description", "eggs");
        jsonObject.put("price", 130);
        jsonObject.put("new", false);
    }

    @Test
    void getMealById() {
    }


    @Test
    void getAllMealByRestoID() throws Exception {
        mockMvc.perform(get("/meal/resto/1").with(httpBasic("tanea@gmail.com", "321321321")))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasItem(jsonObject)));
    }

    @Test
    void unauthorisedAccess() throws Exception {
        mockMvc.perform(get("/meal/resto/1").with(httpBasic("wrong@email.com", "wrongpassword")))
                .andExpect(status().isUnauthorized())
                .andDo(print());
    }
}