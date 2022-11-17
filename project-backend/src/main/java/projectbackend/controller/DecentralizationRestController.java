package projectbackend.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.decentralization.UserDto;
import projectbackend.model.decentralization.User;
import projectbackend.service.decentralization.IUserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class DecentralizationRestController {

    @Autowired
    private IUserService userService;

    @PatchMapping("/edit/{username}")
    public ResponseEntity<?> editUser(@RequestBody @Valid UserDto userDto,
                                      BindingResult bindingResult,
                                      String userName) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            user.setUsername(userName);
            BeanUtils.copyProperties(userDto, user);
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

//    @GetMapping("/find/{username}")
//    public ResponseEntity<User> editusername(@PathVariable String username) {
//        User user = userService.findByUsername(username).get();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }


    @PostMapping("/add")
    public ResponseEntity<List<FieldError>> saveUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
