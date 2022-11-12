package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectbackend.model.decentralization.User;

import java.util.Optional;

@Repository
<<<<<<< HEAD
public interface IUserRepository extends JpaRepository<User, Integer> {
=======
public interface IUserRepository extends JpaRepository<User, String> {
>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900
    @Query(value = "select * from user where username like %:username% and is_delete = 0", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);


}
