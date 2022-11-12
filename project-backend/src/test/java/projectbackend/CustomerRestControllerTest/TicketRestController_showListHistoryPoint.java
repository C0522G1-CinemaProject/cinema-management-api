package projectbackend.CustomerRestControllerTest;


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
public class TicketRestController_showListHistoryPoint {
    @Autowired
    private MockMvc mockMvc;

    //test page = null => page = 0;
    @Test
    public void showListHistoryPoint_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = "" => page = 0;
    @Test
    public void showListHistoryPoint_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = 1000 => No Content;
    @Test
    public void showListHistoryPoint_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?page=1000"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test page = 0, element = 1 == ok
    @Test
    public void showListHistoryPoint_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(29))
                .andExpect(jsonPath("totalElements").value(144))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Alfie"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].price").value(25000));

    }

    //test search startTime = null => No Content
    @Test
    public void showListHistoryPoint_startTime_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=null"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test search startTime = "" => isOk, e sài RequestParam,
    @Test
    public void showListHistoryPoint_startTime_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime="))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //test search startTime = không tồn tại DB => isNoContent,
    @Test
    public void showListHistoryPoint_startTime_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=2030-05-29"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test search startTime = tồn tại trong DB => isOke,
    @Test
    public void showListHistoryPoint_startTime_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=2022-11-29"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(29))
                .andExpect(jsonPath("totalElements").value(144))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Alfie"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].price").value(25000))
                .andExpect(jsonPath("content[0].point").value(123123));

    }

    //test search endTime = null => No Content
    @Test
    public void showListHistoryPoint_endTime_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=null"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test search endTime = "" => isOk, e sài RequestParam,
    @Test
    public void showListHistoryPoint_endTime_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime="))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //test search endTime = không tồn tại DB => isNoContent,
    @Test
    public void showListHistoryPoint_endTime_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=2030-05-29"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test search endTime = tồn tại trong DB => isOke,
    @Test
    public void showListHistoryPoint_endTime_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=2022-11-29"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(29))
                .andExpect(jsonPath("totalElements").value(144))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Alfie"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].price").value(25000))
                .andExpect(jsonPath("content[0].point").value(123123));
    }


    //test search price = null => No Content
    @Test
    public void showListHistoryPoint_price_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?bookingTime=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    //test search price = "" => isOk, e sài RequestParam,
    @Test
    public void showListHistoryPoint_price_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?price="))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //test search price = không tồn tại DB => isNoContent,
    @Test
    public void showListHistoryPoint_price_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?price=123213"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test search price = tồn tại trong DB => isOke,
    @Test
    public void showListHistoryPoint_price_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/history/point?price=25000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(29))
                .andExpect(jsonPath("totalElements").value(144))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Alfie"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].price").value(25000))
                .andExpect(jsonPath("content[0].point").value(100000));
    }

}
