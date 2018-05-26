package al.edu.fti.entity;

import al.edu.fti.enums.StatusEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "last_login_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_deletion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeletion;

    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "date_birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBirthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy="user")
    private Set<StudentDetail> studentDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<LecturerDetail> lecturerDetails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Course> courses;

    @ManyToMany(mappedBy = "users")
    private Set<Course> employees = new HashSet<Course>();

    public User() {
    }

    public User(String username, String firstName, String lastName, String email, String password, Date lastLoginDate, String gender, Date dateDeletion, Date dateUpdate, Date dateCreation, StatusEnum status, Date dateBirthday, String phoneNumber, Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.gender = gender;
        this.dateDeletion = dateDeletion;
        this.dateUpdate = dateUpdate;
        this.dateCreation = dateCreation;
        this.status = status;
        this.dateBirthday = dateBirthday;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateDeletion() {
        return dateDeletion;
    }

    public void setDateDeletion(Date dateDeletion) {
        this.dateDeletion = dateDeletion;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<StudentDetail> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(Set<StudentDetail> studentDetails) {
        this.studentDetails = studentDetails;
    }

    public Set<LecturerDetail> getLecturerDetails() {
        return lecturerDetails;
    }

    public void setLecturerDetails(Set<LecturerDetail> lecturerDetails) {
        this.lecturerDetails = lecturerDetails;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Course> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Course> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != null ? !idUser.equals(user.idUser) : user.idUser != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (lastLoginDate != null ? !lastLoginDate.equals(user.lastLoginDate) : user.lastLoginDate != null)
            return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (dateDeletion != null ? !dateDeletion.equals(user.dateDeletion) : user.dateDeletion != null) return false;
        if (dateUpdate != null ? !dateUpdate.equals(user.dateUpdate) : user.dateUpdate != null) return false;
        if (dateCreation != null ? !dateCreation.equals(user.dateCreation) : user.dateCreation != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (dateBirthday != null ? !dateBirthday.equals(user.dateBirthday) : user.dateBirthday != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (studentDetails != null ? !studentDetails.equals(user.studentDetails) : user.studentDetails != null)
            return false;
        if (lecturerDetails != null ? !lecturerDetails.equals(user.lecturerDetails) : user.lecturerDetails != null)
            return false;
        if (courses != null ? !courses.equals(user.courses) : user.courses != null) return false;
        return employees != null ? employees.equals(user.employees) : user.employees == null;
    }

    @Override
    public int hashCode() {
        int result = idUser != null ? idUser.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastLoginDate != null ? lastLoginDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (dateDeletion != null ? dateDeletion.hashCode() : 0);
        result = 31 * result + (dateUpdate != null ? dateUpdate.hashCode() : 0);
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateBirthday != null ? dateBirthday.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (studentDetails != null ? studentDetails.hashCode() : 0);
        result = 31 * result + (lecturerDetails != null ? lecturerDetails.hashCode() : 0);
        result = 31 * result + (courses != null ? courses.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", gender='" + gender + '\'' +
                ", dateDeletion=" + dateDeletion +
                ", dateUpdate=" + dateUpdate +
                ", dateCreation=" + dateCreation +
                ", status=" + status +
                ", dateBirthday=" + dateBirthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", studentDetails=" + studentDetails +
                ", lecturerDetails=" + lecturerDetails +
                ", courses=" + courses +
                ", employees=" + employees +
                '}';
    }
}
