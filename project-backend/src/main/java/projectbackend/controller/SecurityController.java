package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projectbackend.common.IEmailService;
import projectbackend.dto.decentralization.IUserEmailDto;
import projectbackend.jwt.JwtTokenUtil;
import projectbackend.model.decentralization.User;
import projectbackend.payload.reponse.MessageResponse;
import projectbackend.payload.request.LoginRequest;
import projectbackend.payload.request.LoginResponse;
import projectbackend.payload.request.ResetPassRequest;
import projectbackend.service.decentralization.impl.MyUserDetails;
import projectbackend.service.decentralization.impl.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
@RequestMapping("api/public")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private IEmailService iEmailService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String home() {
        return "/index";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(loginRequest.getUsername());
        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(myUserDetails);
        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new LoginResponse(
                        jwt,
                        myUserDetails.getUsername(),
                        roles));
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<MessageResponse> forgotPassword(@RequestParam String email){
        Optional<IUserEmailDto> iUserEmailDto = userService.findByEmail(email);
//        System.out.println(iUserEmailDto.get().getUsername());
        if (!iUserEmailDto.isPresent()) {
            return new ResponseEntity<>(new MessageResponse("Email không tồn tại trong hệ thống"), HttpStatus.NOT_FOUND);
        }
        IUserEmailDto userEmailDto = iUserEmailDto.get();
        String token = this.jwtTokenUtil.generateJwtToken(userEmailDto.getUsername());
//        System.out.println(token);
        String resetPasswordLink = "http://localhost:4200/confirm-reset-password/" + token;
        if (iEmailService.sendEmail(email, resetPasswordLink)) {
            return new ResponseEntity<>(new MessageResponse("Gửi email thành công"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageResponse("Gửi email thất bại"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/comfirm-reset-password")
    public ResponseEntity<MessageResponse> resetPassword(@RequestBody ResetPassRequest request) {
        String username = jwtTokenUtil.getUsernameFromJwtToken(request.getToken());
//        System.out.println(username);
        Optional<IUserEmailDto> iUserEmailDto = userService.findByUsernameDto(username);
        if (!iUserEmailDto.isPresent()) {
            return new ResponseEntity<>(new MessageResponse("Link đổi mật khẩu đã hết hiệu lực"), HttpStatus.BAD_REQUEST);
        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return new ResponseEntity<>(new MessageResponse("Mật khẩu không trùng khớp"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(username,request.getPassword());
        userService.updatePassword(user , request.getPassword());
        return new ResponseEntity<>(new MessageResponse("Đổi mật khẩu thành công"), HttpStatus.OK);
    }
}
