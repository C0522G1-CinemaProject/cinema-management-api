package projectbackend.service.room;

import projectbackend.model.room.Room;
import projectbackend.dto.room.IRoomDto;

import java.util.List;

public interface IRoomService {

    List<Room> getListRoom();

    List<IRoomDto> findAllRoom(String name);

    IRoomDto findRoomById(String id);
}
