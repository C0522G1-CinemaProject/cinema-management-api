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
    IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Optional<IUserEmailDto> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<IUserEmailDto> findByUsernameDto(String username) {
        return userRepository.findByUsernameDto(username);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        userRepository.saveNewPassword(encodedPassword,user.getUsername());
    }
}

