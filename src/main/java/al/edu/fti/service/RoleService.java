package al.edu.fti.service;

import al.edu.fti.dao.IRoleDAO;
import al.edu.fti.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    private IRoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(IRoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDAO.getRoleById(id);
    }
}
