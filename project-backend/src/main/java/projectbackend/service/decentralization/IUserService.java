package projectbackend.service.decentralization;

import projectbackend.model.decentralization.User;

import java.util.List;


public interface IUserService {
    String existsByUserName(String username);

    List<User> findAll();

    User findByUsername(String name);
}
