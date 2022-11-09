package projectbackend.service.room.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.booking_ticket.ISeatDetail;
import projectbackend.model.room.SeatRoom;
import projectbackend.repository.room.ISeatRoomRepository;
import projectbackend.service.room.ISeatRoomService;

import java.util.List;

@Service
public class SeatRoomService implements ISeatRoomService {
    @Autowired
    private ISeatRoomRepository seatRoomRepository;

    @Override
    public List<SeatRoom> findAll() {
        return seatRoomRepository.findAll();
    }
}
