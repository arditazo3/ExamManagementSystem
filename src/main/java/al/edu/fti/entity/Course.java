package al.edu.fti.entity;

import al.edu.fti.enums.StatusEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long idCourse;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "year")
    private String year;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private User user;

    @OneToMany(mappedBy="course", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Exam> exams;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_student",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    Set<User> usersRelatedToCourse = new HashSet<User>();

    public Course() {
    }

    public Course(String description, String code, StatusEnum status, String year, String remarks, String grade) {
        this.description = description;
        this.code = code;
        this.status = status;
        this.year = year;
        this.remarks = remarks;
        this.grade = grade;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public Set<User> getUsersRelatedToCourse() {
        return usersRelatedToCourse;
    }

    public void setUsersRelatedToCourse(Set<User> usersRelatedToCourse) {
        this.usersRelatedToCourse = usersRelatedToCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (idCourse != null ? !idCourse.equals(course.idCourse) : course.idCourse != null) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (code != null ? !code.equals(course.code) : course.code != null) return false;
        if (status != null ? !status.equals(course.status) : course.status != null) return false;
        if (year != null ? !year.equals(course.year) : course.year != null) return false;
        if (remarks != null ? !remarks.equals(course.remarks) : course.remarks != null) return false;
        if (grade != null ? !grade.equals(course.grade) : course.grade != null) return false;
        if (user != null ? !user.equals(course.user) : course.user != null) return false;
        if (exams != null ? !exams.equals(course.exams) : course.exams != null) return false;
        return usersRelatedToCourse != null ? usersRelatedToCourse.equals(course.usersRelatedToCourse) : course.usersRelatedToCourse == null;
    }

}
