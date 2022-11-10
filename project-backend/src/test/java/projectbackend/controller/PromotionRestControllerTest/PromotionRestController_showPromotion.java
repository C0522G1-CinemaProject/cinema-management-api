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
public class PromotionRestController_showPromotion {

    @Autowired
    private MockMvc mockMvc;

    // test page = null => page = 0
    @Test
    public void showPromotion_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/promotion/list?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page = "" => page = 0
    @Test
    public void showPromotion_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page = 8 => No content
    @Test
    public void showPromotion_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=8"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // test page = 0
    @Test
    public void showPromotion_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(5))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].name").value("Khuyến mãi năm mới"))
                .andExpect(jsonPath("content[0].image").value("https://img.websosanh.vn/v10/users/review/images/71lfkzep6qyvw/cvdgvxp-770x403.jpg?compress=85"))
                .andExpect(jsonPath("content[0].startTime").value("2022-11-10"))
                .andExpect(jsonPath("content[0].endTime").value("2022-11-15"))
                .andExpect(jsonPath("content[0].detail").value("giảm giá chương trình"))
                .andExpect(jsonPath("content[0].discount").value("5"))
                .andExpect(jsonPath("content[0].delete").value(false));
    }
}
