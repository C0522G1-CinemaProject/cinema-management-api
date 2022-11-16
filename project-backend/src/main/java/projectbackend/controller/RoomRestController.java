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
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.room.IRoomDto;
import projectbackend.dto.room.ISeatRoomDto;
import projectbackend.dto.room.IdSeatTypeDTo;
import projectbackend.dto.room.SeatRoomDto;
import projectbackend.service.room.IRoomService;
import projectbackend.service.room.ISeatRoomService;

import java.util.List;
import java.util.Optional;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/room")

public class RoomRestController {

    @Autowired
    private IRoomService roomService;

    @Autowired
    private ISeatRoomService iSeatRoomService;

    @GetMapping("")
    public ResponseEntity<List<Room>> getListRoom() {
        List<Room> rooms = roomService.getListRoom();

        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/seat-room/{id}")
    public ResponseEntity<List<ISeatRoomDto>> findSeatRoomByRoomId(@PathVariable(value = "id") Integer id) {

        List<ISeatRoomDto> seatList = iSeatRoomService.findSeatRoomByRoomId(id);
        if (seatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(seatList, HttpStatus.OK);
    }

    @PatchMapping(value = "/updateStatusSeatRoom/{idSeatRoom}", name = "/updateStatusSeatRoom")
    public ResponseEntity<IdSeatTypeDTo> updateSeatRoom(@PathVariable("idSeatRoom") Integer idSeatRoom, @RequestBody IdSeatTypeDTo idSeatTypeDto) {
        if (idSeatRoom == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (iSeatRoomService.findSeatRoomById(idSeatRoom) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iSeatRoomService.updateSeatRoom(idSeatRoom, idSeatTypeDto.getIdSeatType());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
