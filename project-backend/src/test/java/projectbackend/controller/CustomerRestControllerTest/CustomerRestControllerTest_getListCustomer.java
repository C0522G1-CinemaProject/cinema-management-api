package projectbackend.controller.CustomerRestControllerTest;


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
public class CustomerRestControllerTest_getListCustomer {
    @Autowired
    private MockMvc mockMvc;

    // test page = null => page = 0;
    @Test
    public void getListCustomer_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page ="" => page = 0;
    @Test
    public void getListCustomer_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = 7 => No content
    @Test
    public void getListCustomer_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer?page=7"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getListCustomer_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(6))
                .andExpect(jsonPath("totalElements").value(30))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].name").value("Barnie Boscher"))
                .andExpect(jsonPath("content[0].dayOfBirth").value("1981-05-22"))
                .andExpect(jsonPath("content[0].gender").value(2))
                .andExpect(jsonPath("content[0].idCard").value("578856430"))
                .andExpect(jsonPath("content[0].email").value("bboscher0@vistaprint.com"))
                .andExpect(jsonPath("content[0].address").value("5"))
                .andExpect(jsonPath("content[0].phoneNumber").value("0909850091"));



    }
}
