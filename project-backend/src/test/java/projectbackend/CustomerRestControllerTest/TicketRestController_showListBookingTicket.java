package projectbackend.CustomerRestControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketRestController_showListBookingTicket {

    @Autowired
    private MockMvc mockMvc;

    //test page = null => page = 0;
    @Test
    public void showListBookingTicket_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //test page = "" => page = 0;
    @Test
    public void showListBookingTicket_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    // test page = 1000 => No Content
    @Test
    public void showListBookingTicket_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?page=1000"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


   //test page = 0, element = 1 == ok
    @Test
    public void showListBookingTicket_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Reincarnated"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].ticketId").value(21));

    }

    //test size = 0
    @Test
    public void showListBookingTicket_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?size=0"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //test size = 2, element = 1 == isOk
    @Test
    public void showListBookingTicket_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/booking/ticket?size=2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].statusTicket").value(1))
                .andExpect(jsonPath("content[0].movieName").value("Reincarnated"))
                .andExpect(jsonPath("content[0].bookingTime").value("2022-11-29 00:00:00.0"))
                .andExpect(jsonPath("content[0].ticketId").value(21));

    }


}
