//package projectbackend.service.ticket;
//
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import projectbackend.dto.ticket.ITicketDto;
//import projectbackend.model.ticket.Ticket;
//
//import java.util.Optional;
//
//public interface ITicketService {
//<<<<<<< HEAD
//    Page<ITicketDto> findAllByQuery(Integer ticketId,
//                                    Integer customerId,
//                                    String idCard,
//                                    String phoneNumber,
//                                    Pageable pageable);
//
//    Ticket findTicketById(Integer id);
//
//    void saveTicket(Ticket ticket);
//=======
//    Page<ITicketDto> findAllBookingTickets(Pageable pageable, String username);
//
//    Page<ITicketDto> findAllCanceledTickets(Pageable pageable, String username);
//
//    Page<ITicketDto> findAllHistoryPointSearch(String username, String bookingTime, int value, Pageable pageable);
//
//    Page<ITicketDto> findAllHistoryPoint(String username, String bookingTime, Pageable pageable);
//
//    Optional<Ticket> findByIdTicKet(Integer id);
//
//    void deleteTicket(Integer id);
//>>>>>>> 64d10b2d9de9139a708810c54b62b43d556033c6
//}
