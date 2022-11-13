package projectbackend.service.decentralization;

import projectbackend.model.decentralization.User;

import java.util.Optional;

public interface IUserService {

    void saveUser(User user);

    Optional<User> findByUsername(String username);

    void updateUser(User user);


}
