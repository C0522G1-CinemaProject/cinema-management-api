package projectbackend.service.decentralization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.decentralization.Role;
import projectbackend.repository.decentralization.IRoleRepository;
import projectbackend.service.decentralization.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;


    @Override
    public List<Role> findAllRole() {
        return iRoleRepository.findAll();
    }

    public List<Role> getAllRoles() {
        return iRoleRepository.finAllRole();

    }
}
