package projectbackend.service.room;

import projectbackend.dto.room.ISeatRoomDto;

import java.util.List;

public interface ISeatRoomService {

    void updateSeatRoom(Integer idSeatRoom);

    List<ISeatRoomDto> findAllBySeat(Integer id);

}
