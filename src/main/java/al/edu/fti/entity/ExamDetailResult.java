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
    private ExamQuestion examQuestion;

    public Long getIdExamDetailResult() {
        return idExamDetailResult;
    }

    public void setIdExamDetailResult(Long idExamDetailResult) {
        this.idExamDetailResult = idExamDetailResult;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public ExamQuestion getExamQuestion() {
        return examQuestion;
    }

    public void setExamQuestion(ExamQuestion examQuestion) {
        this.examQuestion = examQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamDetailResult that = (ExamDetailResult) o;

        if (idExamDetailResult != null ? !idExamDetailResult.equals(that.idExamDetailResult) : that.idExamDetailResult != null)
            return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        return examQuestion != null ? examQuestion.equals(that.examQuestion) : that.examQuestion == null;
    }

    @Override
    public String toString() {
        return "ExamDetailResult{" +
                "idExamDetailResult=" + idExamDetailResult +
                ", answer=" + answer +
                ", examQuestion=" + examQuestion +
                '}';
    }
}
