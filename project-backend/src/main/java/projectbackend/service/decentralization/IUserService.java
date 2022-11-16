package projectbackend.service.decentralization;

import projectbackend.dto.decentralization.IUserEmailDto;
import projectbackend.model.decentralization.User;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    String existsByUserName(String username);

    List<User> findAll();


    Optional<IUserEmailDto> findByEmail(String email);

    Optional<IUserEmailDto> findByUsernameDto(String username);

    void updatePassword(User user, String newPassword);

    Optional<User> findUserByUsername(String username);

    void updateUser(User user, String username);

}