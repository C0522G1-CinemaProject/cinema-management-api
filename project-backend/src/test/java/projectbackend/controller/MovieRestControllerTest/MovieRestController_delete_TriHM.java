package projectbackend.controller.MovieRestControllerTest;

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
public class MovieRestController_delete_TriHM {

    @Autowired
    private MockMvc mockMvc;

    //test id = null
    @Test
    public void delete_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/delete/null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test id = "" -> Not Found
    @Test
    public void delete_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/delete/"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test id = 11 --> Not Found
    @Test
    public void delete_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/delete/11/"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //test id = 1 -->Ok

    @Test
    public void delete_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/movie/delete/1/"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
