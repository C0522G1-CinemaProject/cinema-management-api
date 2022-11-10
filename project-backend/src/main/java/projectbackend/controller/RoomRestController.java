package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.room.IRoomDto;
import projectbackend.dto.room.ISeatRoomDto;
import projectbackend.service.room.IRoomService;
import projectbackend.service.room.ISeatRoomService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/admin/roomRest")
public class RoomRestController {

    @Autowired
    private IRoomService iRoomService;

    @Autowired
    private ISeatRoomService iSeatRoomService;

    @GetMapping(value = "")
    public ResponseEntity<List<IRoomDto>> displayPawnItem(@RequestParam Optional<String> name) {

        String keywordName = name.orElse("");

        List<IRoomDto> roomList = iRoomService.findAllRoom(keywordName);
        if (roomList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IRoomDto> displayPawnItem(@PathVariable String id) {

        IRoomDto room = iRoomService.findRoomById(id);
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/seat-room/{id}")
    public ResponseEntity<List<ISeatRoomDto>> findAllBySeat(@PathVariable(value = "id") Integer id) {

        List<ISeatRoomDto> seatList = iSeatRoomService.findAllBySeat(id);
        if (seatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }

}
