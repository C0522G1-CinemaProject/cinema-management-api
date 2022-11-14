package projectbackend.controller.EmployeeRestControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_deleteEmployee {

    @Autowired
    private MockMvc mockMvc;

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test deleteEmployee by id = null
     * */

    @Test
    public void deleteEmployeeById_id_25() throws Exception {
this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/null"))
        .andDo(print())
        .andExpect(status().isBadRequest());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test deleteEmployee by id = ""
     * */

    @Test
    public void deleteEmployeeById_id_26() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test deleteEmployee by id = "32" not in database
     * */

    @Test
    public void deleteEmployeeById_id_27() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/32"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    /**
     * creator Nguyen Van Phu
     * create date : 10/11/2022
     * content: test deleteEmployee by id = "30"  in database
     * */

    @Test
    public void deleteEmployeeById_id_28() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/employee/delete/30"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
