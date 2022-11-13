package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.decentralization.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String> {

    @Query(value = "select username, password from user where username = :username and is_delete = 0", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

    @Modifying
    @Query(value = "insert into user(username, password) values (:#{#user.username},:#{#user.password} )",nativeQuery = true)
    void createUser(@Param("user") User user);

//    @Modifying
//    @Query(value = "update user set password = :password where username = :user",nativeQuery = true)
//    void updateUser(@Param("password") String password,
//                    @Param("user") String user);
}
