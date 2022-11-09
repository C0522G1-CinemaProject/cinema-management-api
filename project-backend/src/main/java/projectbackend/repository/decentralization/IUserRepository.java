package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectbackend.model.decentralization.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    User findByUsername(String name);
}
