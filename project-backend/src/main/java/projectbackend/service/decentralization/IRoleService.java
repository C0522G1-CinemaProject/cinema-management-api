package projectbackend.service.decentralization;

import projectbackend.model.decentralization.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAllRole();

    List<Role> getAllRoles();

}
