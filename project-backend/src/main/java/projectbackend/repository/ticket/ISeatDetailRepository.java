package projectbackend.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.ticket.SeatDetail;

public interface ISeatDetailRepository extends JpaRepository<SeatDetail, Integer> {

    /**Dai nhap*/

    @Query(value = "insert into seat_detail(show_time_id,seat_room_id) values show_time_id = :showTime, seat_room_id = :seatRoom", nativeQuery = true)
    void creatSeatDetail(@Param("showTime") int showTime, @Param("seatRoom") int seatRoom);
}
