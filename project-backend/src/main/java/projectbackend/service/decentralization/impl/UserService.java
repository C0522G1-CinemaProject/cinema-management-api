package projectbackend.service.decentralization.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectbackend.model.decentralization.User;
import projectbackend.repository.decentralization.IUserRepository;
import projectbackend.service.decentralization.IUserService;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iuserRepository;

    @Override
    public void saveUser(User user) {
        iuserRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return iuserRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        iuserRepository.save(user);
    }

}
