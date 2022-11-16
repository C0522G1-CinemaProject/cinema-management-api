package projectbackend.service.decentralization;

import org.springframework.beans.factory.annotation.Autowired;
import projectbackend.dto.decentralization.IUserEmailDto;
import projectbackend.model.decentralization.User;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    void saveUser(User user);

    void updateUser(User user);

    String existsByUserName(String username);

    List<User> findAll();

    User findByUsername(String name);

    Optional<IUserEmailDto> findByEmail(String email);

    Optional<IUserEmailDto> findByUsernameDto(String username);

    void updatePassword(User user, String newPassword);


}
