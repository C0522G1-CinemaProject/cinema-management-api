package projectbackend.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.model.ticket.SeatDetail;

import java.util.List;

public interface ISeatDetailRepository extends JpaRepository<SeatDetail, Integer> {
    @Query(value = "select seat_room.id as id, seat_room.room_id as roomId, seat_room.seat_type_id as seatTypeId, " +
            "seat.name as seatName, seat_type.price as price, seat_detail.show_time_id as showTimeId, " +
            "seat_detail.status_seat as seatStatus " +
            "from seat_room " +
            "join seat on seat_room.seat_id = seat.id " +
            "join seat_type on seat_room.seat_type_id = seat_type.id " +
            "join room on room.id = seat_room.room_id " +
            "join show_times on show_times.room_id = room.id " +
            "join seat_detail on seat_detail.show_time_id = show_times.id " +
            "where show_times.id = :idShowTime and seat_room.room_id = :idRoom and seat_room.is_delete = 0;",
            nativeQuery = true)
    List<ISeatDetail> findAllSeatDetail(@Param("idShowTime") Integer idShowTime, @Param("idRoom") Integer idRoom);
}
