package projectbackend.repository.ticket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.ticket.ITicketDto;
import projectbackend.model.ticket.Ticket;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket " +
            "from ticket " +
            "join customer on customer.id = ticket.customer_id " +
            "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
            "join show_times on show_times.id = seat_detail.show_time_id " +
            "join movie on movie.id = show_times.movie_id " +
            "join room on room.id = show_times.room_id " +
            "join seat_room on seat_room.room_id = room.id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where customer.id = :id " +
            "and ticket.is_delete = 0 ",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.id = :id " +
                    "and ticket.is_delete = 0 ", nativeQuery = true)
    Page<ITicketDto> findAllBookingTickets(@Param("id") Integer id, Pageable pageable);

    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket " +
            "from ticket " +
            "join customer on customer.id = ticket.customer_id " +
            "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
            "join show_times on show_times.id = seat_detail.show_time_id " +
            "join movie on movie.id = show_times.movie_id " +
            "join room on room.id = show_times.room_id " +
            "join seat_room on seat_room.room_id = room.id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where customer.id = :id " +
            "and ticket.is_delete = 1 ",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.id = :id " +
                    "and ticket.is_delete = 1 ", nativeQuery = true)
    Page<ITicketDto> findAllCanceledTickets(@Param("id") Integer id, Pageable pageable);


    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket, saving_point.point as point , seat_type.price as price" +
            "from ticket " +
            "join customer on customer.id = ticket.customer_id " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
            "join show_times on show_times.id = seat_detail.show_time_id " +
            "join movie on movie.id = show_times.movie_id " +
            "join room on room.id = show_times.room_id " +
            "join seat_room on seat_room.room_id = room.id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where customer.id = :id and ticket.ticket_booking_time like :bookingTime and seat_type.price like :price ",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.id = :id and ticket.ticket_booking_time like :bookingTime and " +
                    "seat_type.price like :price", nativeQuery = true)
    Page<ITicketDto> findAllHistoryPoint(@Param("id") Integer id,
                                         @Param("booKingTime") String bookingTime,
                                         @Param("price") int price,
                                         Pageable pageable);

}
