package al.edu.fti.entity;

import javax.persistence.*;

@Entity
@Table(name = "lecturer_detail")
public class LecturerDetail {

    @Id
    @GeneratedValue
    private Long idLecturerDetail;

    @Column(name = "lecturer_code")
    private String lecturerCode;

    @Column(name = "address")
    private String address;

    @Column(name = "place_birthday")
    private String placeBirthday;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    public LecturerDetail() {
    }

    public LecturerDetail(String lecturerCode, String address, String placeBirthday, String email) {
        this.lecturerCode = lecturerCode;
        this.address = address;
        this.placeBirthday = placeBirthday;
        this.email = email;
    }

    public Long getIdLecturerDetail() {
        return idLecturerDetail;
    }

    public void setIdLecturerDetail(Long idLecturerDetail) {
        this.idLecturerDetail = idLecturerDetail;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

        LecturerDetail that = (LecturerDetail) o;

        if (idLecturerDetail != null ? !idLecturerDetail.equals(that.idLecturerDetail) : that.idLecturerDetail != null)
            return false;
        if (lecturerCode != null ? !lecturerCode.equals(that.lecturerCode) : that.lecturerCode != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (placeBirthday != null ? !placeBirthday.equals(that.placeBirthday) : that.placeBirthday != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        int result = idLecturerDetail != null ? idLecturerDetail.hashCode() : 0;
        result = 31 * result + (lecturerCode != null ? lecturerCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (placeBirthday != null ? placeBirthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LecturerDetail{" +
                "idLecturerDetail=" + idLecturerDetail +
                ", lecturerCode='" + lecturerCode + '\'' +
                ", address='" + address + '\'' +
                ", placeBirthday='" + placeBirthday + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
