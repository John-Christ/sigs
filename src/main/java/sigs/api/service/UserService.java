package sigs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import sigs.api.model.DAOUser;
import sigs.api.model.Role;
import sigs.api.repository.DaoUser;
import sigs.api.repository.RoleRepository;

import java.util.Set;

public class UserService {


    @Autowired
    private DaoUser daouser;


    @Autowired
    private RoleRepository roleRepository;



    public  DAOUser assignRoleToUser(Long id, Long roleId ) {
        Set<Role> roleSet = null;
        DAOUser user = daouser.findById(id).get();
        Role role = roleRepository.findById(roleId).get();
        roleSet =  user.getAssignedRoles();
        roleSet.add(role);
        user.setAssignedRoles(roleSet);
        return daouser.save(user);
    }
}
