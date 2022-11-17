package projectbackend.service.ticket;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.customer.Customer;
import projectbackend.model.customer.CustomerType;
import projectbackend.model.ticket.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    Page<ITicketDto> findAllBookingTickets(Pageable pageable, String username);

    Page<ITicketDto> findAllCanceledTickets(Pageable pageable, String username);


    Page<ITicketDto> findAllHistoryPoint(String username, String startTime, String endTime, Pageable pageable);

    Page<ITicketDto> findAllOfPointsAdded(String username, String startTime, String endTime, Pageable pageable);

    Page<ITicketDto> findAllOfUsePoints(String username, String startTime, String endTime, Pageable pageable);


    void deleteTicket(Integer id);


    Page<ITicketDto> findAllByQuery(Integer ticketId,
                                    Integer customerId,
                                    String idCard,
                                    String phoneNumber,
                                    Pageable pageable);

    Optional<Ticket> findTicketById(Integer id);


    void saveTicket(Ticket ticket);

    //    List<ITicketDto> findByCustomerNameAndPoint(String username);
    Optional<ITicketDto> findByCustomerNameAndPoint(String username);


}
