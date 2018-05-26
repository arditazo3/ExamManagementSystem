package al.edu.fti.entity;

import javax.persistence.*;

@Entity
@Table(name = "exam_detail_result")
public class ExamDetailResult {

    @Id
    @GeneratedValue
    private Long idExamDetailResult;

    @Column(name = "answer")
    private Boolean answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "exam_question_id")
    private Exam exam;

    public ExamDetailResult() {
    }

    public ExamDetailResult(Boolean answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamDetailResult that = (ExamDetailResult) o;

        if (idExamDetailResult != null ? !idExamDetailResult.equals(that.idExamDetailResult) : that.idExamDetailResult != null)
            return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        return exam != null ? exam.equals(that.exam) : that.exam == null;
    }

    @Override
    public int hashCode() {
        int result = idExamDetailResult != null ? idExamDetailResult.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (exam != null ? exam.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExamDetailResult{" +
                "idExamDetailResult=" + idExamDetailResult +
                ", answer=" + answer +
                ", exam=" + exam +
                '}';
    }
}
