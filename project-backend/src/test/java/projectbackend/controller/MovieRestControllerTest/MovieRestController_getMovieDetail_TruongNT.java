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
public class MovieRestController_getMovieDetail_TruongNT {
    @Autowired
    private MockMvc mockMvc;

    //test id = null => Not Found
    @Test
    public void getMovieDetail_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/movie/detail/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    // test id = "" => Not Found;
    @Test
    public void getMovieDetail_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/movie/detail/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    //test id = 500 => No Content

    @Test
    public void getMovieDetail_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/movie/detail/500"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Test id = 1 => OK
    @Test
    public void getMovieDetail_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/movie/detail/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Alfie"))
                .andExpect(jsonPath("image").value("http://dummyimage.com/108x100.png/ff4444/ffffff"))
                .andExpect(jsonPath("startDay").value("2023-03-16"))
                .andExpect(jsonPath("endDay").value("2023-10-06"))
                .andExpect(jsonPath("director").value("Gard McGibbon"))
                .andExpect(jsonPath("filmTime").value("158"))
                .andExpect(jsonPath("trailer").value("http://dummyimage.com/116x100.png/cc0000/ffffff"))
                .andExpect(jsonPath("movieType").value("Kiếm hiệp"))
                .andExpect(jsonPath("content").value("Comedy|Drama|Romance"))
                .andExpect(jsonPath("filmStudio").value("Flashspan"))
                .andExpect(jsonPath("actor").value("Aldrich Izon"))
                .andExpect(jsonPath("version").value("1"));

    }


}
