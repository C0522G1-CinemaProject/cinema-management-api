package projectbackend.controller.PromotionRestControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PromotionRestController_findById {

    @Autowired
    private MockMvc mockMvc;

    // test id = null
    @Test
    public void showPromotion_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // test id = ""
    @Test
    public void showPromotion_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    // test id = 21
    @Test
    public void showPromotion_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/21"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // test id = 1
    @Test
    public void showPromotion_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Khuyến mãi năm mới"))
                .andExpect(jsonPath("image").value("https://img.websosanh.vn/v10/users/review/images/71lfkzep6qyvw/cvdgvxp-770x403.jpg?compress=85"))
                .andExpect(jsonPath("startTime").value("2022-11-10"))
                .andExpect(jsonPath("endTime").value("2022-11-15"))
                .andExpect(jsonPath("detail").value("giảm giá chương trình"))
                .andExpect(jsonPath("discount").value("5"))
                .andExpect(jsonPath("delete").value(false));
    }
}
