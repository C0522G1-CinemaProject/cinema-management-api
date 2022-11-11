package projectbackend.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.dto.ticket.ITicketManagerDto;
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

    @Query(value = "SELECT customer.name AS nameCustomer, customer.email AS email, customer.id_card as idCard, customer.phone_number as phoneNumber, room.name as nameRoom, show_times.date_projection as dateProjection, times.start_time as startTime, seat.name as nameSeat, seat_type.price as price\n" +
            "FROM ticket\n" +
            "INNER JOIN customer ON ticket.customer_id = customer.id\n" +
            "INNER JOIN seat_detail ON ticket.seat_detail_id = seat_detail.id\n" +
            "INNER JOIN show_times ON seat_detail.show_time_id = show_times.id\n" +
            "INNER JOIN room ON show_times.room_id = room.id\n" +
            "INNER JOIN times ON show_times.times_id = times.id\n" +
            "INNER JOIN seat_room ON room.id = seat_room.room_id\n" +
            "INNER JOIN seat ON seat_room.seat_id = seat.id\n" +
            "INNER JOIN seat_type ON seat_room.seat_type_id = seat_type.id\n" +
            "WHERE ticket.id=:id AND ticket.is_delete = 0 limit 1", nativeQuery = true)
    Optional<ITicketDto> findInfoTicketById(@Param("id") int id);


    @Query(value = "SELECT " +
            "ticket.id AS ticketId, " +
            "customer.id AS customerId, " +
            "customer.name AS customerName, " +
            "customer.id_card AS idCard, " +
            "customer.phone_number AS phoneNumber, " +
            "movie.name AS movieName, " +
            "show_times.date_projection as dateProjection, " +
            "times.start_time AS startTime, " +
            "room.name AS roomName, " +
            "seat.name AS seatName, " +
            "ticket.status_ticket AS statusTicket " +
            "FROM " +
            "ticket " +
            "JOIN " +
            "customer ON ticket.customer_id = customer.id " +
            "JOIN " +
            "seat_detail ON ticket.seat_detail_id = seat_detail.id " +
            "JOIN " +
            "show_times ON seat_detail.show_time_id = show_times.id " +
            "JOIN " +
            "movie ON show_times.movie_id = movie.id " +
            "JOIN " +
            "times ON show_times.times_id = times.id " +
            "JOIN " +
            "room ON show_times.room_id = room.id " +
            "JOIN " +
            "seat_room ON seat_detail.seat_room_id = seat_room.id " +
            "JOIN " +
            "seat ON seat_room.seat_id = seat.id " +
            "WHERE " +
            "ticket.id like %:ticketCodeSearch% " +
            "AND customer.id like %:customerCodeSearch% " +
            "AND customer.id_card like %:idCardSearch% " +
            "AND customer.phone_number like %:phoneSearch% " +
            "AND ticket.is_delete = 0 " +
            "AND ticket.status_ticket = 1 ",
            countQuery = "SELECT " +
                    "count(*) " +
                    "FROM " +
                    "ticket " +
                    "JOIN " +
                    "customer ON ticket.customer_id = customer.id " +
                    "JOIN " +
                    "seat_detail ON ticket.seat_detail_id = seat_detail.id " +
                    "JOIN " +
                    "show_times ON seat_detail.show_time_id = show_times.id " +
                    "JOIN " +
                    "movie ON show_times.movie_id = movie.id " +
                    "JOIN " +
                    "times ON show_times.times_id = times.id " +
                    "JOIN " +
                    "room ON show_times.room_id = room.id " +
                    "JOIN " +
                    "seat_room ON seat_detail.seat_room_id = seat_room.id " +
                    "JOIN " +
                    "seat ON seat_room.seat_id = seat.id " +
                    "WHERE " +
                    "ticket.id like %:ticketCodeSearch% " +
                    "AND customer.id like %:customerCodeSearch% " +
                    "AND customer.id_card like %:idCardSearch% " +
                    "AND customer.phone_number like %:phoneSearch% " +
                    "AND ticket.is_delete = 0 " +
                    "AND ticket.status_ticket = 1 "
            , nativeQuery = true)
    Page<ITicketManagerDto> findAllByQuery(@Param("ticketCodeSearch") Integer ticketId,
                                           @Param("customerCodeSearch") Integer customerId,
                                           @Param("idCardSearch") String idCard,
                                           @Param("phoneSearch") String phoneNumber,
                                           Pageable pageable);

    @Query(value = "SELECT id, is_delete, customer_id, seat_detail_id, status_ticket, ticket_booking_time " +
            "FROM ticket WHERE id =:id AND is_delete = 0 ", nativeQuery = true)
    Optional<Ticket> findTicketManagerById(@Param("id") Integer id);

    @Modifying
    @Query(value = "UPDATE ticket SET status_ticket = 2 WHERE id =:idEdit ", nativeQuery = true)
    void editTicketManager(@Param("idEdit") Integer id);
}
