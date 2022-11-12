package projectbackend.service.ticket;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

public interface ITicketService {
    Page<ITicketDto> findAllBookingTickets(Pageable pageable, String username);

    Page<ITicketDto> findAllCanceledTickets(Pageable pageable, String username);

    Page<ITicketDto> findAllHistoryPointSearch(String username, String bookingTime, int value, Pageable pageable);

    Page<ITicketDto> findAllHistoryPoint(String username, String bookingTime, Pageable pageable);

    Page<ITicketDto> findAllBigPoint(String username, String bookingTime, Pageable pageable);
    Page<ITicketDto> findAllSmallPoint(String username, String bookingTime, Pageable pageable);

    Optional<Ticket> findByIdTicKet(Integer id);

    void deleteTicket(Integer id);
}
