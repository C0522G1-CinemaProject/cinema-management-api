package projectbackend.service.room.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.room.ISeatRoomDto;
import projectbackend.repository.room.ISeatRoomRepository;
import projectbackend.service.room.ISeatRoomService;

import java.util.List;

@Service
public class SeatRoomService implements ISeatRoomService {

    @Autowired
    ISeatRoomRepository iSeatRoomRepository;

    @Override
    public void updateSeatRoom(Integer idSeatRoom) {
        iSeatRoomRepository.updateSeatRoom(idSeatRoom);
    }

    @Override
    public List<ISeatRoomDto> findAllBySeat(Integer id) {
        return iSeatRoomRepository.findAllBySeat(id);
    }
}
