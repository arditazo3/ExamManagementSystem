package al.edu.fti.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue
    private Long idExam;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "course_id")
    private Course course;

    @OneToMany(mappedBy="exam", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>();

    public Long getIdExam() {
        return idExam;
    }

    public void setIdExam(Long idExam) {
        this.idExam = idExam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<ExamQuestion> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(Set<ExamQuestion> examQuestions) {
        this.examQuestions = examQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (idExam != null ? !idExam.equals(exam.idExam) : exam.idExam != null) return false;
        if (description != null ? !description.equals(exam.description) : exam.description != null) return false;
        if (course != null ? !course.equals(exam.course) : exam.course != null) return false;
        return examQuestions != null ? examQuestions.equals(exam.examQuestions) : exam.examQuestions == null;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExam +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", examQuestions=" + examQuestions +
                '}';
    }
}
