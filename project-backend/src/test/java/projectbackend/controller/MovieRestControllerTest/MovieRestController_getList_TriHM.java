package projectbackend.controller.MovieRestControllerTest;

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
public class MovieRestController_getList_TriHM {
    @Autowired
    private MockMvc mockMvc;

    // test page = null => page = 0;
    @Test
    public void getList_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=null&name=a"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page ="" => page =0;
    @Test
    public void getList_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=&name=a"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test page = 21 => No content
    @Test
    public void getList_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=21&name=a"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void getList_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=0&name=a"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].name").value("Reincarnated"));
    }


    //test name = null => No content
    @Test
    public void getListMovie_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=0&name=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name = null => Default value is "" -> list film
    @Test
    public void getListMovie_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=0&name="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test name = null => Default value is "" -> list film
    @Test
    public void getListMovie_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=0&name=BlackAdam"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void getListMovie_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/movie/list?page=0&name=My Foolish Heart"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
