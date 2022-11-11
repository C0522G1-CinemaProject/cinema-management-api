package projectbackend.service.decentralization.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.decentralization.User;
import projectbackend.repository.decentralization.IUserRepository;
import projectbackend.service.decentralization.IUserService;

import java.util.List;


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
    public User findByUsername(String name) {
        return iUserRepository.findByUsername(name);
    }
}