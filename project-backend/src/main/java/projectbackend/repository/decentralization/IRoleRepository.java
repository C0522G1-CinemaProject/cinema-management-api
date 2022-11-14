package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projectbackend.model.decentralization.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "select * from role",nativeQuery = true)
    List<Role> finAllRole();

}
