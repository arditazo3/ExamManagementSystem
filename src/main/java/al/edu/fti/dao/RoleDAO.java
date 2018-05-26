package al.edu.fti.dao;

import al.edu.fti.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDAO implements IRoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
