package projectbackend.controller.EmployeeRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.decentralization.UserDto;
import projectbackend.dto.employee.EmployeeDto;
import projectbackend.model.decentralization.User;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_createEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test name = null
    @Test
    public void createEmployee_name_1() throws Exception {
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
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name = ""
    @Test
    public void createEmployee_name_2() throws Exception {
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
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( min length)
    @Test
    public void createEmployee_name_3() throws Exception {
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
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( max length)
    @Test
    public void createEmployee_name_4() throws Exception {
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
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name ( format)
    @Test
    public void createEmployee_name_5() throws Exception {
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
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth = null
    @Test
    public void createEmployee_name_6() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth(null);
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test dayOfBirth = ""
    @Test
    public void createEmployee_name_7() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("");
        employeeDto.setGender(1);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender = null
    @Test
    public void createEmployee_name_8() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(null);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test gender => gender > 2
    @Test
    public void createEmployee_name_9() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(4);
        employeeDto.setAddress("0252");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address = null
    @Test
    public void createEmployee_name_10() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress(null);
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address ( format)
    @Test
    public void createEmployee_name_11() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("15a24");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address => max length
    @Test
    public void createEmployee_name_12() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhha  jjgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test address min length
    @Test
    public void createEmployee_name_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("l");
        employeeDto.setEmail("temett3@si.edu");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = null
    @Test
    public void createEmployee_name_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail(null);
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email = ""
    @Test
    public void createEmployee_name_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test email ( format )
    @Test
    public void createEmployee_name_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("12345678");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard = null
    @Test
    public void createEmployee_name_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard(null);
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test idCard = null
    @Test
    public void createEmployee_name_18() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber(null);
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test image = null
    @Test
    public void createEmployee_name_19() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage(null);
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user = null
    @Test
    public void createEmployee_name_20() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername(null);
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test idCard = ""
    @Test
    public void createEmployee_name_21() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test phoneNumber = ""
    @Test
    public void createEmployee_name_22() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test img = ""
    @Test
    public void createEmployee_name_23() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test user = ""
    @Test
    public void createEmployee_name_24() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("003583535");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test idCard ( format ) idCard = 9 or idCard = 12
    @Test
    public void createEmployee_name_25() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName("Huyjrrr");
        employeeDto.setDayOfBirth("1996-03-12");
        employeeDto.setGender(1);
        employeeDto.setAddress("viet nam");
        employeeDto.setEmail("huydn@gmail.com");
        employeeDto.setIdCard("02100000");
        employeeDto.setPhoneNumber("0909550396");
        employeeDto.setImage("https://scontent.fsgn2-6.fna.fbcdn.net/v/t1.6435-9/54435713_1097858383733899_2565263526427885568_n.jp_nc_cat=111&ccb=1-7&_nc_sid=ad2b24&_nc_ohc=PSCWCgK4qkYAX87Lrym&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfDjvsYjb2F_NRjEbocvrJesou6qwcRdK5XDi3a3IaDyVw&oe=638C6C4E");
        User user = new User();
        user.setUsername("cmatteottir");
        employeeDto.setUserDto(user);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }







}
