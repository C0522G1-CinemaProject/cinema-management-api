package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;

public interface ITicketService {
    Page<ITicketDto> findAllBookingTickets(Pageable pageable, String username);

    Page<ITicketDto> findAllCanceledTickets(Pageable pageable, String username);

    Page<ITicketDto> findAllHistoryPoint(String username, String bookingTime, int price, Pageable pageable);

    Page<ITicketDto> findAllHistoryPointSearch(String username, String bookingTime, Pageable pageable);
}
