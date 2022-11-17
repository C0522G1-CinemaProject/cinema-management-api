package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
import projectbackend.model.ticket.Ticket;
import java.util.Optional;

public interface ITicketService {
    Optional<Ticket> findById(Integer id);

    void updateTicketById(int id);

    Optional<ITicketDto> findTicketById(int id);

    void saveTicket(Ticket ticket);

    Page<ITicketManagerDto> findAllByTicketManagerDto(Pageable pageable,
//                                           Integer ticketId,
//                                           Integer customerId,
                                           String idCard,
                                           String phoneNumber
                                           );

    Optional<ITicketManagerDto> findTicketManagerById(int id);

    void editTicketManager(int id);
}
