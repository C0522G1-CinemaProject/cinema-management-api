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
public class MovieRestController_getAllMovie_NamHV {

    @Autowired
    private MockMvc mockMvc;

    //Test parameter pageable
    // Suppose: name = alfie is true.
    // test page = null => default page = 0;
    @Test
    public void getAllMovie_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/list?name=alfie&page=null")).andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Suppose: name = alfie is true.
    // test page = "" => Default page = 0;
    @Test
    public void getAllMovie_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/movie/list?name=alfie&page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // Suppose: name = alfie is true.
    // test Because totalPage = 3 if page = 4 => No Content
    @Test
    public void getAllMovie_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/movie/list?name=alfie&page=4"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //Test parameter name
    //Suppose: page = 0 is true.
    // test name = null => No Content(204)
    @Test
    public void getAllMovie_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/list?page=0&name=null"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //Suppose: page = 0 is true.
    // test name = "" => All movie list default page = 0;
    @Test
    public void getAllMovie_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/list?page=0&name="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //Suppose: page = 0 is true.
    // test name = Nam@@@ => No Content(204);
    @Test
    public void getAllMovie_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/movie/list?page=0&name=Nam@@@"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //Test successful.
    @Test
    public void getAllMovie_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/movie/list?page=0&name=Alfie"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].movieName").value("Alfie"))
                .andExpect(jsonPath("content[0].showTimeDate").value("2022-11-13"))
                .andExpect(jsonPath("content[0].movieFilmTime").value(158));

    }
}
