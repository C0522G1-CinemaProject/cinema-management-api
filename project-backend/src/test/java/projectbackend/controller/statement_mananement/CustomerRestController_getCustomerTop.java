package projectbackend.controller.statement_mananement;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CustomerRestController_getCustomerTop {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * test numberMonth = null => numberMonth = 0
     */
    @Test
    public void getCustomerTop_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/statement?numberMonth=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * test numberMonth = "" => numberMonth = 0
     */
    @Test
    public void getCustomerTop_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/statement?numberMonth="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * test numberMonth = -11 ko có trong DB
     */
    @Test
    public void getCustomerTop_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/statement?numberMonth=-11"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * test numberMonth = 1 no content
     */
    @Test
    public void getCustomerTop_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/statement?numberMonth=1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void getCustomerTop_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/customer/statement?numberMonth=12"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
