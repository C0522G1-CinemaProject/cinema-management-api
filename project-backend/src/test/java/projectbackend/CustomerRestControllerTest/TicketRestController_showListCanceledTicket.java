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
public class TicketRestController_showListCanceledTicket {
    @Autowired
    private MockMvc mockMvc;

    //test page = null => page = 0;
    @Test
    public void showListCanceledTicket_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = "" => page = 0;
    @Test
    public void showListCanceledTicket_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = 1000 => No Content;
    @Test
    public void showListCanceledTicket_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?page=1000"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    //test page = 0, element = 1 == ok
    @Test
    public void showListBookingTicket_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].statusTicket").value(0))
                .andExpect(jsonPath("content[0].movieName").value("Reincarnated"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-04 00:00:00.0"))
                .andExpect(jsonPath("content[0].ticketId").value(38));

    }

    //test size = 0,
    @Test
    public void showListCanceledTicket_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?size=0"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test size = 2, element = 2 == ok
    @Test
    public void showListBookingTicket_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/canceled/ticket?size=2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].statusTicket").value(0))
                .andExpect(jsonPath("content[0].movieName").value("Reincarnated"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-04 00:00:00.0"))
                .andExpect(jsonPath("content[0].ticketId").value(38));

    }



}
