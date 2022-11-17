package projectbackend.service.ticket;

<<<<<<< HEAD
import projectbackend.model.ticket.Ticket;

public interface ITicketService {
=======

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

>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
    void saveTicket(Ticket ticket);
}
