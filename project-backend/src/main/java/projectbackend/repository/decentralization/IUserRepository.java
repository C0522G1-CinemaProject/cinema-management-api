package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projectbackend.model.decentralization.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where username like %:username% and is_delete = 0", nativeQuery = true)
    Optional<User> findByUsername(@Param("username") String username);

    
}
