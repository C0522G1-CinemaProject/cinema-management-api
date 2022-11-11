package projectbackend.service.room.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.room.Room;
import projectbackend.repository.room.IRoomRepository;
import projectbackend.service.decentralization.IRoleService;
import projectbackend.service.room.IRoomService;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private IRoomRepository roomRepository;

    @Override
    public List<Room> getListRoom() {
        return roomRepository.findAll();
    }
}
