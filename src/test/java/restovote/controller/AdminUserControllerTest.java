package restovote.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class AdminUserControllerTest extends AbstractControllerTest {

    private static final String URL = "/admin/users/1";

    @Test
    void editUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL))
                .andDo(print());
    }
}