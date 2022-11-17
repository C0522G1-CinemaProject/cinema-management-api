package projectbackend.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.ticket.ITicketDto;
>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
import projectbackend.model.ticket.Ticket;

@Transactional
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
<<<<<<< HEAD
    @Modifying
    @Query(value = "insert into ticket (is_delete, customer_id, seat_detail_id, status_ticket, ticket_booking_time) " +
            "values (0, :idCustomer, :idSeatDetail, 0, now());", nativeQuery = true)
    void addPendingTicket(@Param("idCustomer") Integer idCustomer, @Param("idSeatDetail") Integer idSeatDetail);
=======

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
    Page<ITicketDto> findAllByQuery(@Param("ticketCodeSearch") Integer ticketId,
                                    @Param("customerCodeSearch")Integer customerId,
                                    @Param("idCardSearch") String idCard,
                                    @Param("phoneSearch") String phoneNumber,
                                    Pageable pageable);
>>>>>>> 1a83e5008e5de991e35f34f1054772e2067509ba
}
