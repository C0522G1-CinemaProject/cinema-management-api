package projectbackend.service.ticket;

import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;
import java.util.Optional;

public interface ITicketService {
    Optional<Ticket> findById(Integer id);

    void updateTicketById(int id);

    Optional<ITicketDto> findTicketById(int id);

    void saveTicket(Ticket ticket);
}
