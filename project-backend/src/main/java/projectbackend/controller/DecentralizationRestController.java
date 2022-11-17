package projectbackend.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.decentralization.UserDto;
import projectbackend.dto.decentralization.UpdatePasswordUserDto;
import projectbackend.model.decentralization.User;
import projectbackend.service.decentralization.IUserService;
import projectbackend.service.decentralization.impl.MyUserDetails;
import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class DecentralizationRestController {
    @Autowired
    private IUserService userService;
    @PatchMapping("/edit")
    public ResponseEntity<?> editUser(@RequestBody @Valid UpdatePasswordUserDto userDto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            String username = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            User temp = userService.findUserByUsername(username).orElse(null);
            if (new BCryptPasswordEncoder().matches(userDto.getPassword(), temp.getPassword())) {
                user.setPassword(new BCryptPasswordEncoder().encode(userDto.getNewPassword()));
                userService.updateUser(user, username);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                String mess = "Mật khẩu không đúng";
                return new ResponseEntity<>(mess, HttpStatus.BAD_REQUEST);
            }
        }
    }
//    @PostMapping("/add")
//    public ResponseEntity<List<FieldError>> saveUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(),
//                    HttpStatus.BAD_REQUEST);
//        }
//        User user = new User();
//        BeanUtils.copyProperties(userDto, user);
//        userService.updateUser(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
