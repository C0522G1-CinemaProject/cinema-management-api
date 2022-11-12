package projectbackend.repository.ticket;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;

import java.util.Optional;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket, seat_type.price as price, ticket.id as ticketId   " +
            "from ticket " +
            "join customer on customer.id = ticket.customer_id " +
            "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
            "join show_times on show_times.id = seat_detail.show_time_id " +
            "join movie on movie.id = show_times.movie_id " +
            "join room on room.id = show_times.room_id " +
            "join seat_room on seat_room.room_id = room.id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where customer.username = :username " +
            "and ticket.is_delete = 0 group by ticket.id ",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.username = :username " +
                    "and ticket.is_delete = 0 group by ticket.id ", nativeQuery = true)
    Page<ITicketDto> findAllBookingTickets(@Param("username") String username, Pageable pageable);

    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket, seat_type.price as price, ticket.id as ticketId " +
            "from ticket " +
            "join customer on customer.id = ticket.customer_id " +
            "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
            "join show_times on show_times.id = seat_detail.show_time_id " +
            "join movie on movie.id = show_times.movie_id " +
            "join room on room.id = show_times.room_id " +
            "join seat_room on seat_room.room_id = room.id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where customer.username = :username " +
            "and ticket.is_delete = 1 group by ticket.id",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.username = :username " +
                    "and ticket.is_delete = 1  group by ticket.id", nativeQuery = true)
    Page<ITicketDto> findAllCanceledTickets(@Param("username") String username, Pageable pageable);


    @Query(value = "select saving_point.day_booking as bookingTime," +
            "saving_point.point as point ," +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and saving_point.day_booking like %:bookingTime% " +
            "and saving_point.point = :point  ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and saving_point.day_booking like %:bookingTime% and " +
                    "saving_point.point = :point  ", nativeQuery = true)
    Page<ITicketDto> findAllHistoryPointSearch(@Param("username") String username,
                                               @Param("bookingTime") String bookingTime,
                                               @Param("point") int value,
                                               Pageable pageable);


    @Query(value = "select saving_point.point as point ,saving_point.day_booking as bookingTime " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and saving_point.day_booking like %:bookingTime% ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and saving_point.day_booking like %:bookingTime% "
            , nativeQuery = true)
    Page<ITicketDto> findAllHistoryPoint(@Param("username") String username,
                                         @Param("bookingTime") String bookingTime,
                                         Pageable pageable);

    @Query(value = "select saving_point.day_booking as bookingTime," +
            "saving_point.point as point " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and saving_point.day_booking like %:bookingTime% " +
            "and saving_point.point > 0  ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and saving_point.day_booking like %:bookingTime% and " +
                    "saving_point.point > 0  ", nativeQuery = true)
    Page<ITicketDto> findAllBigPointSearch(@Param("username") String username,
                                           @Param("bookingTime") String bookingTime,
                                           Pageable pageable);

    @Query(value = "select saving_point.day_booking as bookingTime," +
            "saving_point.point as point " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and saving_point.day_booking like %:bookingTime% " +
            "and saving_point.point < 0  ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and saving_point.day_booking like %:bookingTime% and " +
                    "saving_point.point < 0  ", nativeQuery = true)
    Page<ITicketDto> findAllSmallPointSearch(@Param("username") String username,
                                             @Param("bookingTime") String bookingTime,
                                             Pageable pageable);

    @Query(value = "select id,is_delete,customer_id,seat_detail_id,status_ticket,ticket_booking_time " +
            "from ticket " +
            "where id = :id ", countQuery = "select count (*) from ticket " +
            "where id = :id ", nativeQuery = true)
    Optional<Ticket> findByIdTicket(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update ticket set is_delete = 1 where ticket.id = :id", nativeQuery = true)
    void deleteTicket(@Param("id") Integer id);
}
