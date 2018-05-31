package al.edu.fti.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam_result")
public class ExamResult {

    @Id
    @GeneratedValue
    private Long idExamResult;

    @Column(name = "result")
    private String result;

    @Column(name = "exam_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date examEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "student_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "exam_id")
    private Exam exam;

    public ExamResult() {
    }

    public ExamResult(String result, Date examEndDate) {
        this.result = result;
        this.examEndDate = examEndDate;
    }

    public Long getIdExamResult() {
        return idExamResult;
    }

    public void setIdExamResult(Long idExamResult) {
        this.idExamResult = idExamResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getExamEndDate() {
        return examEndDate;
    }

    public void setExamEndDate(Date examEndDate) {
        this.examEndDate = examEndDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        ExamResult that = (ExamResult) o;

        if (idExamResult != null ? !idExamResult.equals(that.idExamResult) : that.idExamResult != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        return examEndDate != null ? examEndDate.equals(that.examEndDate) : that.examEndDate == null;
    }

    @Override
    public int hashCode() {
        int result1 = idExamResult != null ? idExamResult.hashCode() : 0;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (examEndDate != null ? examEndDate.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "idExamResult=" + idExamResult +
                ", result='" + result + '\'' +
                ", examEndDate=" + examEndDate +
                '}';
    }
}
