package al.edu.fti.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue
    private Long idExam;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "course_id")
    private Exam exam;

    @OneToMany(mappedBy="exam")
    private Set<ExamQuestion> examQuestions;

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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam1 = (Exam) o;

        if (idExam != null ? !idExam.equals(exam1.idExam) : exam1.idExam != null) return false;
        if (description != null ? !description.equals(exam1.description) : exam1.description != null) return false;
        return exam != null ? exam.equals(exam1.exam) : exam1.exam == null;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExam +
                ", description='" + description + '\'' +
                ", exam=" + exam +
                '}';
    }
}
