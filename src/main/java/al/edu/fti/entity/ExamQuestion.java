package al.edu.fti.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "exam_question")
public class ExamQuestion {

    @Id
    @GeneratedValue
    private Long idExamQuestion;

    @Column(name = "question")
    private String question;

    @Column(name = "type_question_mandatory")
    private Boolean typeQuestionMandatory;

    @Column(name = "answer")
    private Boolean answer;

    @Column(name = "order")
    private Integer order;

    @Column(name = "visibility")
    private Boolean visibility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "exam_id")
    private Exam exam;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private Set<ExamDetailResult> examDetailResults;

    public ExamQuestion() {
    }

    public ExamQuestion(String question, Boolean typeQuestionMandatory, Boolean answer, Integer order, Boolean visibility) {
        this.question = question;
        this.typeQuestionMandatory = typeQuestionMandatory;
        this.answer = answer;
        this.order = order;
        this.visibility = visibility;
    }

    public Long getIdExamQuestion() {
        return idExamQuestion;
    }

    public void setIdExamQuestion(Long idExamQuestion) {
        this.idExamQuestion = idExamQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getTypeQuestionMandatory() {
        return typeQuestionMandatory;
    }

    public void setTypeQuestionMandatory(Boolean typeQuestionMandatory) {
        this.typeQuestionMandatory = typeQuestionMandatory;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public Set<ExamDetailResult> getExamDetailResults() {
        return examDetailResults;
    }

    public void setExamDetailResults(Set<ExamDetailResult> examDetailResults) {
        this.examDetailResults = examDetailResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamQuestion that = (ExamQuestion) o;

        if (idExamQuestion != null ? !idExamQuestion.equals(that.idExamQuestion) : that.idExamQuestion != null)
            return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;
        if (typeQuestionMandatory != null ? !typeQuestionMandatory.equals(that.typeQuestionMandatory) : that.typeQuestionMandatory != null)
            return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (visibility != null ? !visibility.equals(that.visibility) : that.visibility != null) return false;
        return examDetailResults != null ? examDetailResults.equals(that.examDetailResults) : that.examDetailResults == null;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "idExamQuestion=" + idExamQuestion +
                ", question='" + question + '\'' +
                ", typeQuestionMandatory=" + typeQuestionMandatory +
                ", answer=" + answer +
                ", order=" + order +
                ", visibility=" + visibility +
                ", examDetailResults=" + examDetailResults +
                '}';
    }
}
