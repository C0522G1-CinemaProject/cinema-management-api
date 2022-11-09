package projectbackend.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.model.room.SeatRoom;

import java.util.List;

public interface ISeatRoomRepository extends JpaRepository<SeatRoom, Integer> {
}
