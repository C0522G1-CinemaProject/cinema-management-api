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
        UserDto userDto = new UserDto();
        userDto.setUserName("cmatteottir");
        employeeDto.setUserDto(userDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }


}
