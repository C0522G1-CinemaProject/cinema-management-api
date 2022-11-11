package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.decentralization.UserDto;
import projectbackend.model.decentralization.User;
import projectbackend.service.decentralization.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class DecentralizationRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ResponseEntity<User> getUser(String username){
        User user = userService.getUser(username);
        if(user.getUsername().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{username}")
    public ResponseEntity<User> editUser(@RequestBody UserDto userDto,
                                           @PathVariable String username) {
        User user = userService.findByUsername(username);
        BeanUtils.copyProperties(userDto, user);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
