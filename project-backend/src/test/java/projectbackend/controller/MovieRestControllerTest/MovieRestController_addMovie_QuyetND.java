package projectbackend.controller.MovieRestControllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import projectbackend.dto.movie.MovieFullDto;
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
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setName(null);
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

//    test actor's name = null
    @Test
    public void addMovie_actors_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor(null);
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay = null
    @Test
    public void addMovie_startDay_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("2022-11-21");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay(null);
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test image = null
    @Test
    public void addMovie_image_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage(null);
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test endDay = null
    @Test
    public void addMovie_endDay_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay(null);
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = null
    @Test
    public void addMovie_director_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector(null);
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime = null
    @Test
    public void addMovie_filmTime_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(null);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer = null
    @Test
    public void addMovie_trailer_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer(null);
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = null
    @Test
    public void addMovie_filmStudio_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio(null);
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test version = null
    @Test
    public void addMovie_version_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(null);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test movieTypeDto = null
    @Test
    public void addMovie_movieTypeDto_13() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(null);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test movie's name = ""
    @Test
    public void addMovie_name_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setName("");
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = ""
    @Test
    public void addMovie_actors_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay = ""
    @Test
    public void addMovie_startDay_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("2022-11-21");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test image = ""
    @Test
    public void addMovie_image_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test endDay = ""
    @Test
    public void addMovie_endDay_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = ""
    @Test
    public void addMovie_director_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime is type of integer, can't test in this case
    @Test
    public void addMovie_filmTime_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(0);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer = ""
    @Test
    public void addMovie_trailer_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = ""
    @Test
    public void addMovie_filmStudio_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test version is type of integer, can't test in this case
    @Test
    public void addMovie_version_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(0);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test movieTypeDto is type of integer, can't test in this case
    @Test
    public void addMovie_movieTypeDto_14() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "H@"
    @Test
    public void addMovie_name_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setName("H@");
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H@"
    @Test
    public void addMovie_actors_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("H@");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test startDay item in this case
    @Test
    public void addMovie_startDay_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("2022-11-21");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test image item in this case
    @Test
    public void addMovie_image_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test endDay item this case
    @Test
    public void addMovie_endDay_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H@"
    @Test
    public void addMovie_director_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("H@");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test filmTime in this case
    @Test
    public void addMovie_filmTime_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(190);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test filmStudio in this case
    @Test
    public void addMovie_filmStudio_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("H");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(0);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_15() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "H"
    @Test
    public void addMovie_name_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setName("H");
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H"
    @Test
    public void addMovie_actors_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("H");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_startDay_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("2022-11-21");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_image_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_endDay_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H"
    @Test
    public void addMovie_director_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("H");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = 190
    @Test
    public void addMovie_filmTime_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(190);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = "H"
    @Test
    public void addMovie_filmStudio_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("H");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(0);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_16() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test movie's name = "Hrtrttttttttttttttttttttttttttttttttrrrrrrr"
    @Test
    public void addMovie_name_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setName("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test actor's name = "H"
    @Test
    public void addMovie_actors_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_startDay_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("2022-11-21");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("1");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_image_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-27");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test startDay don't need to test this case
    @Test
    public void addMovie_endDay_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test director = "H"
    @Test
    public void addMovie_director_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmTime = 190
    @Test
    public void addMovie_filmTime_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(190);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("fdsfsf");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test trailer don't need to test in this case
    @Test
    public void addMovie_trailer_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Disney");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    test filmStudio = "Hrggrrrrrrrrrrrrrrrr"
    @Test
    public void addMovie_filmStudio_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("Hrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test version item in this case
    @Test
    public void addMovie_version_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(0);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(1);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //    don't need to test movieTypeDto item in this case
    @Test
    public void addMovie_movieTypeDto_17() throws Exception {
        MovieFullDto movieFullDto = new MovieFullDto();
        movieFullDto.setActor("Nguyen Duy Quyet");
        movieFullDto.setName("Nguyen Duy Quyet");
        movieFullDto.setStartDay("2022-11-21");
        movieFullDto.setEndDay("2022-11-21");
        movieFullDto.setFilmStudio("version");
        movieFullDto.setFilmTime(150);
        movieFullDto.setDirector("Nguyen Duy Quyet");
        movieFullDto.setTrailer("filmStudio");
        movieFullDto.setVersion(1);
        movieFullDto.setImage("null");
        movieFullDto.setContent("ok");

        MovieTypeDto movieTypeDto = new MovieTypeDto();
        movieTypeDto.setId(0);
        movieFullDto.setMovieType(movieTypeDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/movie/add")
                        .content(this.objectMapper.writeValueAsString(movieFullDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}
