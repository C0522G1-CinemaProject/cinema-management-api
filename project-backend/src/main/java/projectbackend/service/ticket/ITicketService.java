package projectbackend.service.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    Optional<Ticket> findById(Integer id);

    void updateTicketByUserName(String userNameUpdate);

    Optional<Ticket> findTicketCustomerByUserName(String userName);

    List<ITicketDto> findTicketByUsername(String userName);

    void saveTicket(Ticket ticket);

    Page<ITicketManagerDto> findAllByQuery(Pageable pageable,
                                           Integer ticketId,
                                           Integer customerId,
                                           String idCard,
                                           String phoneNumber
                                           );

    Optional<ITicketManagerDto> findTicketManagerById(Integer id);

    void editTicketManager(Integer id);

}
