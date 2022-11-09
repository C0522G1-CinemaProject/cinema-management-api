package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

public interface ITicketService {

    Page<Ticket> findAllTicket(Pageable pageable);

    Optional<Ticket> findById(int id);

    void updateTicketById(int id);

    Page<TicketDto> findTicketById(Pageable pageable, int id);
}
