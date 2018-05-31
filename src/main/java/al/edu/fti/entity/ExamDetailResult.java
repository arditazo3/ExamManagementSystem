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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "student_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "exam_id")
    private Exam exam;

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

        ExamDetailResult that = (ExamDetailResult) o;

        if (idExamDetailResult != null ? !idExamDetailResult.equals(that.idExamDetailResult) : that.idExamDetailResult != null)
            return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (examQuestion != null ? !examQuestion.equals(that.examQuestion) : that.examQuestion != null) return false;
        return user != null ? user.equals(that.user) : that.user == null;
    }

}
