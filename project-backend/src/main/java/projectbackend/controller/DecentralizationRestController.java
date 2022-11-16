package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.model.decentralization.User;
import projectbackend.service.decentralization.IUserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class DecentralizationRestController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getList() {
        List<User> userList = iUserService.findAll();
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
