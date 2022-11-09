package projectbackend.repository.decentralization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectbackend.model.decentralization.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
