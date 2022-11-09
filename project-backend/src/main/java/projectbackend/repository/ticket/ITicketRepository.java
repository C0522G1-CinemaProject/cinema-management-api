package projectbackend.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.TicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Modifying
    @Query(value = "UPDATE ticket SET status_ticket = 1 WHERE id=:idUpdate", nativeQuery = true)
    void updateTicketById(@Param("idUpdate") int id);

    @Query(value = "select * from ticket where is_delete = 0  ", nativeQuery = true)
    Page<Ticket> findAllTicket(Pageable pageable);

    @Query(value = "SELECT * FROM ticket WHERE id =:id AND is_delete = 0", nativeQuery = true)
    Optional<Ticket> findById(@Param("id") int id);

    @Query(value = "SELECT customer.name, customer.email, customer.id_card, customer.phone_number, room.name, show_times.date_projection, times.start_time, seat.name, seat_type.price\n" +
            "FROM ticket\n" +
            "INNER JOIN customer ON ticket.customer_id = customer.id\n" +
            "INNER JOIN seat_detail ON ticket.seat_detail_id = seat_detail.id\n" +
            "INNER JOIN show_times ON seat_detail.show_time_id = seat_detail.id\n" +
            "INNER JOIN room ON show_times.room_id = room.id\n" +
            "INNER JOIN times ON show_times.times_id = times.id\n" +
            "INNER JOIN seat_room ON room.id = seat_room.room_id\n" +
            "INNER JOIN seat ON seat_room.seat_id = seat.id\n" +
            "INNER JOIN seat_type ON seat_room.seat_type_id = seat_type.id" +
            "WHERE id=:id AND is_delete = 0", nativeQuery = true)
    Page<TicketDto> findTicketById(Pageable pageable, @Param("id") int id);


}
