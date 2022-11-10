package projectbackend.controller.PromotionRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.promotion.PromotionDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PromotionRestController_editPromotion {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test name=null
    @Test
    public void createPromotion_name_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName(null);
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount("5");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/edit/1")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
