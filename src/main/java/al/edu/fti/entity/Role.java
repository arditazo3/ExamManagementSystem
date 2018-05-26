package al.edu.fti.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Long idRole;

    @Column(name = "role_description")
    private String roleDescription;

    @OneToMany(mappedBy="role")
    private Set<User> users;

    public Role() {
    }

    public Role(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (idRole != null ? !idRole.equals(role.idRole) : role.idRole != null) return false;
        if (roleDescription != null ? !roleDescription.equals(role.roleDescription) : role.roleDescription != null)
            return false;
        return users != null ? users.equals(role.users) : role.users == null;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", roleDescription='" + roleDescription + '\'' +
                ", users=" + users +
                '}';
    }
}
