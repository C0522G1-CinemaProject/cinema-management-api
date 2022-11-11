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
import projectbackend.dto.decentralization.UserDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_addCustomer {
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

    //test idCard null
    @Test
    public void createCustomer_idCard_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard(null);
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

    //test idCard =""
    @Test
    public void createCustomer_idCard_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("");
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
    //test idCard invalid format
    @Test
    public void createCustomer_idCard_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("abc");
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

    //test idCard min length
    @Test
    public void createCustomer_idCard_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435");
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
    //test idCard max length
    @Test
    public void createCustomer_idCard_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
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

    //test email null
    @Test
    public void createCustomer_email_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail(null);
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test email =""
    @Test
    public void createCustomer_email_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test email invalid format
    @Test
    public void createCustomer_email_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga.com");
        customerDto.setAddress("Nghe An");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address null
    @Test
    public void createCustomer_address_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress(null);
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test address = ""
    @Test
    public void createCustomer_address_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("");
        customerDto.setPhoneNumber("0912123123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test phoneNumber null
    @Test
    public void createCustomer_phoneNumber_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber =""
    @Test
    public void createCustomer_phoneNumber_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber invalid format
    @Test
    public void createCustomer_phoneNumber_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber("BCBQ12412");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test phoneNumber min length
    @Test
    public void createCustomer_phoneNumber_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber max length
    @Test
    public void createCustomer_phoneNumber_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("123435557688474637");
        customerDto.setEmail("ahsfdhasjdga@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber("0912275234234");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test username null
    @Test
    public void createCustomer_username_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName(null);
        userDto.setPassword("123456");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test username = ""
    @Test
    public void createCustomer_username_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("");
        userDto.setPassword("123456");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test username invalid format
    @Test
    public void createCustomer_username_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc_!");
        userDto.setPassword("123456");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password null
    @Test
    public void createCustomer_password_13() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc");
        userDto.setPassword(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password =""
    @Test
    public void createCustomer_password_14() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc");
        userDto.setPassword("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password invalid format
    @Test
    public void createCustomer_password_15() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc");
        userDto.setPassword("12345555555555");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    //test password min length
    @Test
    public void createCustomer_password_16() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc");
        userDto.setPassword("123");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password max length
    @Test
    public void createCustomer_password_17() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("vanphuc");
        userDto.setPassword("1234567891234567890");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test All
    @Test
    public void createCustomer_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("phuc");
        customerDto.setDayOfBirth("1998-12-05");
        customerDto.setGender(1);
        customerDto.setIdCard("187658129");
        customerDto.setEmail("nguyenvanphuc@gmail.com");
        customerDto.setAddress("Nghệ An");
        customerDto.setPhoneNumber("0912345678");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/customer/add")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test user
    @Test
    public void createCustomer_user_18() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserName("van phuc");
        userDto.setPassword("123456abc");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/add")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
