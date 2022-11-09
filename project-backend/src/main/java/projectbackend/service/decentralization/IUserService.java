package projectbackend.service.decentralization;

import projectbackend.model.decentralization.User;

import java.util.List;


public interface IUserService {

    List<User> findAll();

    User findByUsername(String name);
}
