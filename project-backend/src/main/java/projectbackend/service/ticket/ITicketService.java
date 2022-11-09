package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;

public interface ITicketService {
    Page<ITicketDto> findAllBookingTickets(Pageable pageable, Integer id);

    Page<ITicketDto> findAllCanceledTickets(Pageable pageable, Integer id);

    Page<ITicketDto> findAllHistoryPoint(Integer id, String bookingTime, int price, Pageable pageable);
}
