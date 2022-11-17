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
public class PromotionRestController_createPromotion {
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
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test image=null
    @Test
    public void createPromotion_image_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage(null);
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startTime=null
    @Test
    public void createPromotion_startTime_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime(null);
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test endTime= null
    @Test
    public void createPromotion_endTime_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime(null);
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test detail=null
    @Test
    public void createPromotion_detail_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail(null);
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test discount = null
    @Test
    public void createPromotion_discount_13() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name=""
    @Test
    public void createPromotion_name_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test image=""
    @Test
    public void createPromotion_image_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test startTime=""
    @Test
    public void createPromotion_startTime_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test endTime=""
    @Test
    public void createPromotion_endTime_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test detail=""
    @Test
    public void createPromotion_detail_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test discount=""
    @Test
    public void createPromotion_discount_14() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name invalid format
    @Test
    public void createPromotion_name_15() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới@@@@@@");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test startTime invalid format
    @Test
    public void createPromotion_startTime_15() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05@@@@");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test endTime invalid format
    @Test
    public void createPromotion_endTime_15() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05@@@@@");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test detail invalid format
    @Test
    public void createPromotion_detail_15() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé@@@@@@@");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test discount invalid format
    @Test
    public void createPromotion_discount_15() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name minlength
    @Test
    public void createPromotion_name_16() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("K");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("Giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test detail minlength
    @Test
    public void createPromotion_detail_16() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("G");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name maxlength
    @Test
    public void createPromotion_name_17() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mớiKhuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test detail maxlength
    @Test
    public void createPromotion_detail_17() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-05");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá vévvvgiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá végiảm giá vévgiảm giá végiảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test all [item] đều hợp lệ
    @Test
    public void createPromotion_18() throws Exception {
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setName("Khuyến mãi năm mới");
        promotionDto.setImage("https://static.mservice.io/blogscontents/momo-upload-api-200528143622-637262733826352434.jpg");
        promotionDto.setStartTime("2022-01-01");
        promotionDto.setEndTime("2022-01-05");
        promotionDto.setDetail("giảm giá vé");
        promotionDto.setDiscount(5);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/promotion/create")
                        .content(this.objectMapper.writeValueAsString(promotionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}