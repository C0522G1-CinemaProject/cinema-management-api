package projectbackend.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.ticket.Ticket;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Modifying
    @Query(value = "insert into ticket (is_delete, customer_id, seat_detail_id, status_ticket, ticket_booking_time) " +
            "values (0, :idCustomer, :idSeatDetail, 0, now());", nativeQuery = true)
    void addPendingTicket(@Param("idCustomer") Integer idCustomer, @Param("idSeatDetail") Integer idSeatDetail);
}
