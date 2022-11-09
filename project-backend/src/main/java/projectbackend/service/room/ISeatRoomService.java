package projectbackend.service.room;

import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.model.room.SeatRoom;

import java.util.List;

public interface ISeatRoomService {
    List<SeatRoom> findAll();
}
