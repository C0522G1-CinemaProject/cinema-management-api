package projectbackend.service.decentralization.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectbackend.dto.decentralization.IUserEmailDto;
import projectbackend.model.decentralization.User;
import projectbackend.repository.decentralization.IUserRepository;
import projectbackend.service.decentralization.IUserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public String existsByUserName(String username) {
        return iUserRepository.existsByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<IUserEmailDto> findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

    @Override
    public Optional<IUserEmailDto> findByUsernameDto(String username) {
        return iUserRepository.findByUsernameDto(username);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        iUserRepository.saveNewPassword(encodedPassword, user.getUsername());
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return iUserRepository.findUserByUsername(username);
    }

    @Override
    public void updateUser(User user, String username) {
        iUserRepository.saveUser(user, username);
    }
}