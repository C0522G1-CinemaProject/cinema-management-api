package projectbackend.service.ticket;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

public interface ITicketService {
    Page<ITicketDto> findAllByQuery(Integer ticketId,
                                    Integer customerId,
                                    String idCard,
                                    String phoneNumber,
                                    Pageable pageable);

    Ticket findTicketById(Integer id);

    void saveTicket(Ticket ticket);
}
