package projectbackend.controller.EmployeeRestControllerTest;


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
public class EmployeeRestController_getListEmployee {

    @Autowired
    private MockMvc mockMvc;


    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test page = null => page =0
     * */

    @Test
    public void getListEmployee_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/employee/list?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test page ="" => page =0
     * */

    @Test
    public void getListEmployee_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee/list?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test page = 8  => no content
     * */

    @Test
    public void getListEmployee_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/employee/list?page=8"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test page default
     * */

    @Test
    public void getListEmployee_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/employee/list?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(7))
                .andExpect(jsonPath("totalElements").value(25))
                .andExpect(jsonPath("content[1].id").value(7))
                .andExpect(jsonPath("content[1].name").value("Kailey Sutliff"))
                .andExpect(jsonPath("content[1].gender").value(1))
                .andExpect(jsonPath("content[1].address").value("51"))
                .andExpect(jsonPath("content[1].phoneNumber").value("0901369239"))
                .andExpect(jsonPath("content[1].idCard").value("113692928"))
                .andExpect(jsonPath("content[1].dayOfBirth").value("1995-11-24"));
    }
}
