package projectbackend.controller.CustomerRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.customer.CustomerDto;
import projectbackend.dto.customer.CustomerTypeDto;
import projectbackend.model.customer.CustomerType;
import projectbackend.model.decentralization.User;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestControllerTest_editCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    //test name = null
    @Test
    public void editCustomer_name_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(null);
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name = ""
    @Test
    public void editCustomer_name_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name invalid format
    @Test
    public void editCustomer_name_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("@Le Dai Loi");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name  >= minlength
    @Test
    public void editCustomer_name_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Le Dai Lo");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name  <= maxlength
    @Test
    public void editCustomer_name_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Le Dai Loiiiiiiiiiiiiiiiiiiii");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test address = null
    @Test
    public void editCustomer_address_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress(null);
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test address = ""
    @Test
    public void editCustomer_address_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address invalid format
    @Test
    public void editCustomer_address_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress(" ");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address = null
    @Test
    public void editCustomer_dayOfBirth_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth(null);
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address = ""
    @Test
    public void editCustomer_dayOfBirth_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth invalid format
    @Test
    public void editCustomer_dayOfBirth_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("05-22-1999");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender = null
    @Test
    public void editCustomer_gender_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(null);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address = "", gender không test trường hợp rỗng được thưa anh!
//    @Test
//    public void editCustomer_gender_20() throws Exception {
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setName("Barnie Boscher");
//        customerDto.setAddress("5");
//        customerDto.setDayOfBirth("1981-05-22");
//        customerDto.setGender("");
//        customerDto.setPhoneNumber("0909850091");
//        customerDto.setIdCard("578856430");
//        customerDto.setEmail("bboscher0@vistaprint.com");
//
//        CustomerType customerType = new CustomerType();
//        customerType.setId(1);
//        customerDto.setCustomerType(customerType);
//
//        User user = new User();
//        user.setUsername("abristog");
//        customerDto.setUser(user);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .patch("/api/customer/edit/1")
//                        .content(this.objectMapper.writeValueAsString(customerDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().isBadRequest());
//    }

    //test phoneNumber = null
    @Test
    public void editCustomer_phoneNumber_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber(null);
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber = ""
    @Test
    public void editCustomer_phoneNumber_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber invalid format
    @Test
    public void editCustomer_phoneNumber_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber  >= minlength
    @Test
    public void editCustomer_phoneNumber_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("090985009");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber  <= maxlength
    @Test
    public void editCustomer_phoneNumber_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("090985009111111");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard = null
    @Test
    public void editCustomer_idCard_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setIdCard(null);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard = ""
    @Test
    public void editCustomer_idCard_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard invalid format
    @Test
    public void editCustomer_idCard_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("adasdass");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard  >= minlength 9
    @Test
    public void editCustomer_idCard_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("57885643");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard  <= maxlength 12
    @Test
    public void editCustomer_idCard_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("5788564300000");
        customerDto.setEmail("bboscher0@vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = null
    @Test
    public void editCustomer_email_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setIdCard("578856430");
        customerDto.setPhoneNumber("0909850091");
        customerDto.setEmail(null);

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = ""
    @Test
    public void editCustomer_email_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email invalid format
    @Test
    public void editCustomer_email_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Barnie Boscher");
        customerDto.setAddress("5");
        customerDto.setDayOfBirth("1981-05-22");
        customerDto.setGender(2);
        customerDto.setPhoneNumber("0909850091");
        customerDto.setIdCard("578856430");
        customerDto.setEmail("bboscher0vistaprint.com");

        CustomerType customerType = new CustomerType();
        customerType.setId(1);
        customerDto.setCustomerType(customerType);

        User user = new User();
        user.setUsername("abristog");
        customerDto.setUser(user);


        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/edit/1")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
