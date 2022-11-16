package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectbackend.model.room.Room;
import projectbackend.service.room.IRoomService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/room")
public class RoomRestController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("")
    public ResponseEntity<List<Room>> getListRoom() {
        List<Room> rooms = roomService.getListRoom();

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
    }
}
