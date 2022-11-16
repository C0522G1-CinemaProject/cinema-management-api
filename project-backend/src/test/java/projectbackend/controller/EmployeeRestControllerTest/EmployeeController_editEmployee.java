package projectbackend.controller.EmployeeRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.model.decentralization.User;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_editEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //6.11.1.2. Quản
    //test name = null
    @Test
    public void editEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(null);
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name = ""
    @Test
    public void editEmployee_name_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( min length)
    @Test
    public void editEmployee_name_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("H");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( max length)
    @Test
    public void editEmployee_name_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( format)
    @Test
    public void editEmployee_name_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("null1233456");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth = null
    @Test
    public void editEmployee_dayOfBirth_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth(null);
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth = ""
    @Test
    public void editEmployee_dayOfBirth_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender = null
    @Test
    public void editEmployee_gender_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(null);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender => gender > 2
    @Test
    public void editEmployee_gender_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(4);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test address = null
    @Test
    public void editEmployee_address_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress(null);
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address = ""
    @Test
    public void editEmployee_address_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test address ( format)
    @Test
    public void editEmployee_address_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("15a24");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address => max length
    @Test
    public void editEmployee_address_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhha  jjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address min length
    @Test
    public void editEmployee_address_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("l");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = null
    @Test
    public void editEmployee_email_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail(null);
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = ""
    @Test
    public void editEmployee_email_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email ( format )
    @Test
    public void editEmployee_email_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("12345678");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard = null
    @Test
    public void editEmployee_idCard_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard(null);
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber = null
    @Test
    public void editEmployee_phoneNumber_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber(null);
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test image = null
    @Test
    public void editEmployee_image_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage(null);
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user = null
    @Test
    public void editEmployee_user_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername(null);
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test idCard = ""
    @Test
    public void editEmployee_idCard_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber = ""
    @Test
    public void editEmployee_phoneNumber_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test img = ""
    @Test
    public void editEmployee_image_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");

        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user = ""
    @Test
    public void editEmployee_user_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test idCard ( format ) idCard = 9 or idCard = 12
    @Test
    public void editEmployee_idCard_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("02100000");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }



    //test phoneNumber = format
    @Test
    public void editEmployee_phoneNumber_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("00000000");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user ( format)
    @Test
    public void editEmployee_user_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("admin");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email ( min length )
    @Test
    public void editEmployee_email_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email ( max length)
    @Test
    public void editEmployee_email_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("huydngjjggjkgjjgjgjgjgjgjggjgjgjgjgjgjgjggjgjggjgjgjgjghghghghggh@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test image (max length)
    @Test
    public void editEmployee_image_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user (min length)
    @Test
    public void editEmployee_user_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cm");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user (max length)
    @Test
    public void editEmployee_user_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottirggjgjgjgjgjgjgjgjgjgjgjgjgjgjggjgjgjgjgjkgkkksggjgjg");
        user.setPassword("Huy123456");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password = null
    @Test
    public void editEmployee_password_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword(null);
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test password = ""
    @Test
    public void editEmployee_password_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password invalid format
    @Test
    public void editEmployee_password_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("11111");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password min length
    @Test
    public void editEmployee_password_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("h1");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test password max length
    @Test
    public void editEmployee_password_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Trish Emett");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        user.setPassword("huydd213213521321352165564654564654654654564654654564646546546");
        employeeDto.setUser(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/employee/edit/4")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }










}
