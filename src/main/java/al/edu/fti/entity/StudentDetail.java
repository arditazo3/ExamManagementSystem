package al.edu.fti.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue
    private Long idStudentDetail;

    @Column(name = "")
    private String studentCode;

    @Column(name = "")
    private String amzaNumber;

    @Column(name = "")
    private String address;

    @Column(name = "")
    private String placeBirthday;

    @Column(name = "")
    private String religion;

    @Column(name = "")
    private String email;

    @Column(name = "")
    private String fatherName;

    @Column(name = "")
    private String motherName;

    @Column(name = "")
    private String scholarship;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public StudentDetail() {
    }

    public StudentDetail(String studentCode, String amzaNumber, String address, String placeBirthday, String religion, String email, String fatherName, String motherName, String scholarship) {
        this.studentCode = studentCode;
        this.amzaNumber = amzaNumber;
        this.address = address;
        this.placeBirthday = placeBirthday;
        this.religion = religion;
        this.email = email;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.scholarship = scholarship;
    }

    public Long getIdStudentDetail() {
        return idStudentDetail;
    }

    public void setIdStudentDetail(Long idStudentDetail) {
        this.idStudentDetail = idStudentDetail;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getAmzaNumber() {
        return amzaNumber;
    }

    public void setAmzaNumber(String amzaNumber) {
        this.amzaNumber = amzaNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceBirthday() {
        return placeBirthday;
    }

    public void setPlaceBirthday(String placeBirthday) {
        this.placeBirthday = placeBirthday;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentDetail that = (StudentDetail) o;

        if (idStudentDetail != null ? !idStudentDetail.equals(that.idStudentDetail) : that.idStudentDetail != null)
            return false;
        if (studentCode != null ? !studentCode.equals(that.studentCode) : that.studentCode != null) return false;
        if (amzaNumber != null ? !amzaNumber.equals(that.amzaNumber) : that.amzaNumber != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (placeBirthday != null ? !placeBirthday.equals(that.placeBirthday) : that.placeBirthday != null)
            return false;
        if (religion != null ? !religion.equals(that.religion) : that.religion != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fatherName != null ? !fatherName.equals(that.fatherName) : that.fatherName != null) return false;
        if (motherName != null ? !motherName.equals(that.motherName) : that.motherName != null) return false;
        if (scholarship != null ? !scholarship.equals(that.scholarship) : that.scholarship != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = idStudentDetail != null ? idStudentDetail.hashCode() : 0;
        result = 31 * result + (studentCode != null ? studentCode.hashCode() : 0);
        result = 31 * result + (amzaNumber != null ? amzaNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (placeBirthday != null ? placeBirthday.hashCode() : 0);
        result = 31 * result + (religion != null ? religion.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fatherName != null ? fatherName.hashCode() : 0);
        result = 31 * result + (motherName != null ? motherName.hashCode() : 0);
        result = 31 * result + (scholarship != null ? scholarship.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "idStudentDetail=" + idStudentDetail +
                ", studentCode='" + studentCode + '\'' +
                ", amzaNumber='" + amzaNumber + '\'' +
                ", address='" + address + '\'' +
                ", placeBirthday='" + placeBirthday + '\'' +
                ", religion='" + religion + '\'' +
                ", email='" + email + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", scholarship='" + scholarship + '\'' +
                ", user=" + user +
                '}';
    }
}
