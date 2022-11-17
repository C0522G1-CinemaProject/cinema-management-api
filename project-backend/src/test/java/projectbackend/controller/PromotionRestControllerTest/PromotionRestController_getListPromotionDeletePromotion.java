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
public class PromotionRestController_getListPromotionDeletePromotion {
    @Autowired
    private MockMvc mockMvc;

    // test page = null => page = 0 ;
    @Test
    public void getPromotion_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=null&name=ma"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page = "" => page = 0;
    @Test
    public void getPromotion_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=''&name=ma"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test page = 2 => no content
    @Test
    public void getPromotion_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=2&name=ma"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void getPromotion_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0&name=ma"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].name").value("Khuyến mãi ngày quốc tế phụ nữ"))
                .andExpect(jsonPath("content[0].startTime").value("2022-03-08"))
                .andExpect(jsonPath("content[0].discount").value(10));
    }

    // test search = null => no content
    @Test
    public void getPromotion_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0&name=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test search = "", default value = "" => OK
    @Test
    public void getPromotion_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0&name="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test search = @@ => no content
    @Test
    public void getPromotion_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0&name=@@"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void getPromotion_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/promotion/list?page=0&name="))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].id").value(3))
                .andExpect(jsonPath("content[0].name").value("Khuyến mãi ngày quốc tế phụ nữ"))
                .andExpect(jsonPath("content[0].startTime").value("2022-03-08"))
                .andExpect(jsonPath("content[0].discount").value(10));
    }
}
