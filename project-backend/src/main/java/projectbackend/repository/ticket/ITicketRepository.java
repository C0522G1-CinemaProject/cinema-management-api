package projectbackend.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.ITicketDto;
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

    @Query(value = "SELECT id, is_delete, customer_id, seat_detail_id, status_ticket, ticket_booking_time FROM ticket WHERE id =:id AND is_delete = 0", nativeQuery = true)
    Optional<Ticket> findById(@Param("id") Integer id);

    @Query(value = "SELECT customer.name AS nameCustomer, customer.email AS email, customer.id_card as idCard, customer.phone_number as phoneNumber, room.name as nameRoom, show_times.date_projection as dateProjection, times.start_time as startTime, seat.name as nameSeat, seat_type.price as price, movie.name as nameMovie, movie.image as image\n" +
            "FROM ticket\n" +
            "INNER JOIN customer ON ticket.customer_id = customer.id\n" +
            "INNER JOIN seat_detail ON ticket.seat_detail_id = seat_detail.id\n" +
            "INNER JOIN show_times ON seat_detail.show_time_id = show_times.id\n" +
            "INNER JOIN room ON show_times.room_id = room.id\n" +
            "INNER JOIN times ON show_times.times_id = times.id\n" +
            "INNER JOIN seat_room ON room.id = seat_room.room_id\n" +
            "INNER JOIN seat ON seat_room.seat_id = seat.id\n" +
            "INNER JOIN seat_type ON seat_room.seat_type_id = seat_type.id\n" +
            "INNER JOIN movie ON show_times.movie_id = movie.id\n" +
            "WHERE ticket.id=:id AND ticket.status_ticket = 0 AND ticket.is_delete = 0 limit 1", nativeQuery = true)
    Optional<ITicketDto> findTicketById(@Param("id") int id);


}
