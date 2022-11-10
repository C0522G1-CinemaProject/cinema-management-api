package projectbackend.controller.customerRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.customer.CustomerDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_EditCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test name = null
    @Test
    public void createCustomer_name_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(null);
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test name =""
    @Test
    public void createCustomer_name_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test name invalid format
    @Test
    public void createCustomer_name_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc_!");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test name min length
    @Test
    public void createCustomer_name_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ac");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test name max length
    @Test
    public void createCustomer_name_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("asdfghjklwertyuiopxcvbnmưertyuiopdfghjklfghjklsdfghjkl");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth = null
    @Test
    public void createCustomer_dayOfBirth_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth(null);
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test dateOfBirth = ""
    @Test
    public void createCustomer_dayOfBirth_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test dateOfBirth invalid format
    @Test
    public void createCustomer_dayOfBirth_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("05-1998-11");
        customerDto.setGender(1);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender null
    @Test
    public void createCustomer_gender_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(null);
        customerDto.setIdCard("9876549898");
        customerDto.setEmail("ahsgdjkasgd@gmail.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }




}
