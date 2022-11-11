package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.decentralization.User;

public interface IUserRepository extends JpaRepository<User, String> {

    @Query(value = "select password from user where username = :username and is_delete = 0", nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
