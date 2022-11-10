package projectbackend.controller.PromotionRestControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PromotionRestController_deletePromotion {
    @Autowired
    private MockMvc mockMvc;

    // test delete id = null => not found -- id =null => id = ''
    @Test
    public void delete_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/promotion/delete/"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

    // test id = 50 => not found
    @Test
    public void delete_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/promotion/delete/50"))
                .andDo(print())
                .andExpect(status().isNoContent());

    }


    // test id = 10 => OK
    @Test
    public void delete_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/promotion/delete/10"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
