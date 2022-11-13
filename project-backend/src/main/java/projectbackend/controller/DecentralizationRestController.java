package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.decentralization.UserDto;
import projectbackend.model.decentralization.User;
import projectbackend.service.decentralization.IUserService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/user")
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

    @GetMapping("/find/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
