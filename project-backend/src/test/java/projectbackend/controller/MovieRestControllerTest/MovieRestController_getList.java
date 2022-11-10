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
public class MovieRestController_getList {
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
