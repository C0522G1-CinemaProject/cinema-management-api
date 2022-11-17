package projectbackend.service.decentralization;

import projectbackend.dto.decentralization.IUserEmailDto;
import projectbackend.model.decentralization.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void saveUser(User user);

//    Optional<User> findByUsername(String username);

    void updateUser(User user);




    void saveUser(User user);

    User findByUsername(String name);


}
