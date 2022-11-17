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


    /**
     * creator
     * Võ Văn Tý
     * vé đã đặt
     */
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
            "and ticket.status_ticket between 1 and  2 group by ticket.id ",
            countQuery = "select count(*) from ticket " +
                    "join customer on customer.id = ticket.customer_id " +
                    "join seat_detail on seat_detail.id = ticket.seat_detail_id " +
                    "join show_times on show_times.id = seat_detail.show_time_id " +
                    "join movie on movie.id = show_times.movie_id " +
                    "join room on room.id = show_times.room_id " +
                    "join seat_room on seat_room.room_id = room.id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where customer.username = :username " +
                    "and ticket.status_ticket between 1 and  2 group by ticket.id ", nativeQuery = true)
    Page<ITicketDto> findAllBookingTickets(@Param("username") String username, Pageable pageable);


    /**
     * creator
     * Võ Văn Tý
     * Lấy điểm và lấy tên khách hàng
     */
    @Query(value = "select sum(saving_point.point ) as totalPoint, customer.name as customerName " +
            "from customer left join saving_point on saving_point.customer_id = customer.id where customer.username =:username " +
            "group by saving_point.customer_id ", nativeQuery = true)
    Optional<ITicketDto> findByCustomerNameAndPoint(@Param("username") String username);


    /**
     * creator
     * Võ Văn Tý
     * vé đã hủy
     */
    @Query(value = "select movie.name as movieName, ticket.ticket_booking_time as bookingTime," +
            "ticket.status_ticket as statusTicket, seat_type.price as price, ticket.id as ticketId," +
            "ticket.is_delete as isDeleteTicket,customer.name as customerName  " +
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

    /**
     * creator
     * Võ Văn Tý
     * lịch sử cộng điểm và tìm kiếm theo ngày
     */
    @Query(value = "select saving_point.point as point ,saving_point.day_booking as bookingTime," +
            "customer.name as customerName,saving_point.content as movieName   " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) "
            , nativeQuery = true)
    Page<ITicketDto> findAllHistoryPoint(@Param("username") String username,
                                         @Param("startTime") String startTime,
                                         @Param("endTime") String endTime,
                                         Pageable pageable);


    /**
     * creator
     * Võ Văn Tý
     * lịch sử cộng điểm và tìm kiếm theo ngày và tìm kiếm theo sử dụng điểm
     */
    @Query(value = "select saving_point.day_booking as bookingTime," +
            "saving_point.point as point,customer.name as customerName,saving_point.content as movieName  " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) " +
            "and saving_point.point > 0  ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) and " +
                    "saving_point.point > 0  ", nativeQuery = true)
    Page<ITicketDto> findAllOfPointsAdded(@Param("username") String username,
                                           @Param("startTime") String startTime,
                                           @Param("endTime") String endTime,
                                           Pageable pageable);


    /**
     * creator
     * Võ Văn Tý
     * lịch sử cộng điểm và tìm kiếm theo ngày và tìm kiếm theo sử dùng điểm
     */
    @Query(value = "select saving_point.day_booking as bookingTime," +
            "saving_point.point as point,customer.name as customerName,saving_point.content as movieName  " +
            "from customer " +
            "join saving_point on saving_point.customer_id = customer.id " +
            "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) " +
            "and saving_point.point < 0  ",
            countQuery = "select count(*) from customer " +
                    "join saving_point on saving_point.customer_id = customer.id " +
                    "where customer.username = :username and (saving_point.day_booking between :startTime and :endTime) and " +
                    "saving_point.point < 0  ", nativeQuery = true)
    Page<ITicketDto> findAllOfUsePoints(@Param("username") String username,
                                             @Param("startTime") String startTime,
                                             @Param("endTime") String endTime,
                                             Pageable pageable);

    /**
     * creator
     * Võ Văn Tý
     * find by id
     */
    @Query(value = "select id,is_delete,customer_id,seat_detail_id,status_ticket,ticket_booking_time " +
            "from ticket " +
            "where id = :id ", countQuery = "select count (*) from ticket " +
            "where id = :id ", nativeQuery = true)
    Optional<Ticket> findByIdTicket(@Param("id") Integer id);


    /**
     * creator
     * Võ Văn Tý
     * xóa vé
     */
    @Modifying
    @Transactional
    @Query(value = "update ticket set is_delete = 1 where ticket.id = :id", nativeQuery = true)
    void deleteTicket(@Param("id") Integer id);

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
                                    @Param("customerCodeSearch") Integer customerId,
                                    @Param("idCardSearch") String idCard,
                                    @Param("phoneSearch") String phoneNumber,
                                    Pageable pageable);



}

