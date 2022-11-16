package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;

import projectbackend.model.ticket.Ticket;

public interface ITicketService {
    void saveTicket(Ticket ticket);
}
