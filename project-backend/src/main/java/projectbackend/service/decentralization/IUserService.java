package projectbackend.service.decentralization;

import projectbackend.model.decentralization.User;

public interface IUserService {

    User getUser(String username);

    void saveUser(User user);

    User findByUsername(String username);
}
