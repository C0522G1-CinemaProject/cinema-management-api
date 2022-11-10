package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

public interface ITicketService {

    Page<Ticket> findAllTicket(Pageable pageable);

    Optional<Ticket> findById(Integer id);

    void updateTicketById(int id);

    Optional<ITicketDto> findTicketById(int id);
}
