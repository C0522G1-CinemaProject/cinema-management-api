package projectbackend.controller.MovieRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.movie.MovieDto;
import projectbackend.dto.movie.MovieTypeDto;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieRestController_addMovie_QuyetND {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //test movie's name = null
    @Test
    public void addMovie_name_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName(null);
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

//    test actor's name = null
    @Test
    public void addMovie_actors_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor(null);
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay = null
    @Test
    public void addMovie_startDay_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("2022-11-21");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay(null);
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test image = null
    @Test
    public void addMovie_image_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage(null);
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test endDay = null
    @Test
    public void addMovie_endDay_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay(null);
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = null
    @Test
    public void addMovie_director_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector(null);
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime = null
    @Test
    public void addMovie_filmTime_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(null);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer = null
    @Test
    public void addMovie_trailer_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer(null);
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = null
    @Test
    public void addMovie_filmStudio_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio(null);
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test version = null
    @Test
    public void addMovie_version_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(null);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test movieTypeDto = null
    @Test
    public void addMovie_movieTypeDto_13() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(null);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test movie's name = ""
    @Test
    public void addMovie_name_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("");
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = ""
    @Test
    public void addMovie_actors_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay = ""
    @Test
    public void addMovie_startDay_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("2022-11-21");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test image = ""
    @Test
    public void addMovie_image_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test endDay = ""
    @Test
    public void addMovie_endDay_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = ""
    @Test
    public void addMovie_director_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime is type of integer, can't test in this case
    @Test
    public void addMovie_filmTime_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(0);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer = ""
    @Test
    public void addMovie_trailer_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = ""
    @Test
    public void addMovie_filmStudio_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test version is type of integer, can't test in this case
    @Test
    public void addMovie_version_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(0);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test movieTypeDto is type of integer, can't test in this case
    @Test
    public void addMovie_movieTypeDto_14() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "H@"
    @Test
    public void addMovie_name_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("H@");
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H@"
    @Test
    public void addMovie_actors_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("H@");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test startDay item in this case
    @Test
    public void addMovie_startDay_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("2022-11-21");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test image item in this case
    @Test
    public void addMovie_image_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test endDay item this case
    @Test
    public void addMovie_endDay_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H@"
    @Test
    public void addMovie_director_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("H@");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test filmTime in this case
    @Test
    public void addMovie_filmTime_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(190);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test filmStudio in this case
    @Test
    public void addMovie_filmStudio_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("H");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(0);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_15() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "H"
    @Test
    public void addMovie_name_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("H");
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H"
    @Test
    public void addMovie_actors_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("H");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_startDay_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("2022-11-21");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_image_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_endDay_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H"
    @Test
    public void addMovie_director_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("H");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = 190
    @Test
    public void addMovie_filmTime_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(190);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = "H"
    @Test
    public void addMovie_filmStudio_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("H");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(0);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_16() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "Hrtrttttttttttttttttttttttttttttttttrrrrrrr"
    @Test
    public void addMovie_name_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setName("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H"
    @Test
    public void addMovie_actors_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_startDay_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("2022-11-21");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("1");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_image_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-27");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_endDay_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H"
    @Test
    public void addMovie_director_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime = 190
    @Test
    public void addMovie_filmTime_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(190);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("fdsfsf");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Disney");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = "Hrggrrrrrrrrrrrrrrrr"
    @Test
    public void addMovie_filmStudio_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(0);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_17() throws Exception {
        MovieDto movieDto = new MovieDto();
        movieDto.setActor("Nguyen Duy Quyet");
        movieDto.setName("Nguyen Duy Quyet");
        movieDto.setStartDay("2022-11-21");
        movieDto.setEndDay("2022-11-21");
        movieDto.setFilmStudio("version");
        movieDto.setFilmTime(150);
        movieDto.setDirector("Nguyen Duy Quyet");
        movieDto.setTrailer("filmStudio");
        movieDto.setVersion(1);
        movieDto.setImage("null");
        movieDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
