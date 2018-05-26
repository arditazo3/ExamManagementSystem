package al.edu.fti.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "")
public class Exam {

    @Id
    @GeneratedValue
    private Long idExam;

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
    @JoinColumn (name = "course_id")
    private Exam exam;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private Set<ExamDetailResult> examDetailResults;

    public Exam() {
    }

    public Exam(String question, Boolean typeQuestionMandatory, Boolean answer, Integer order, Boolean visibility) {
        this.question = question;
        this.typeQuestionMandatory = typeQuestionMandatory;
        this.answer = answer;
        this.order = order;
        this.visibility = visibility;
    }

    public Long getIdExam() {
        return idExam;
    }

    public void setIdExam(Long idExam) {
        this.idExam = idExam;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
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

        Exam exam1 = (Exam) o;

        if (idExam != null ? !idExam.equals(exam1.idExam) : exam1.idExam != null) return false;
        if (question != null ? !question.equals(exam1.question) : exam1.question != null) return false;
        if (typeQuestionMandatory != null ? !typeQuestionMandatory.equals(exam1.typeQuestionMandatory) : exam1.typeQuestionMandatory != null)
            return false;
        if (answer != null ? !answer.equals(exam1.answer) : exam1.answer != null) return false;
        if (order != null ? !order.equals(exam1.order) : exam1.order != null) return false;
        if (visibility != null ? !visibility.equals(exam1.visibility) : exam1.visibility != null) return false;
        if (exam != null ? !exam.equals(exam1.exam) : exam1.exam != null) return false;
        return examDetailResults != null ? examDetailResults.equals(exam1.examDetailResults) : exam1.examDetailResults == null;
    }

    @Override
    public int hashCode() {
        int result = idExam != null ? idExam.hashCode() : 0;
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (typeQuestionMandatory != null ? typeQuestionMandatory.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (visibility != null ? visibility.hashCode() : 0);
        result = 31 * result + (exam != null ? exam.hashCode() : 0);
        result = 31 * result + (examDetailResults != null ? examDetailResults.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExam +
                ", question='" + question + '\'' +
                ", typeQuestionMandatory=" + typeQuestionMandatory +
                ", answer=" + answer +
                ", order=" + order +
                ", visibility=" + visibility +
                ", exam=" + exam +
                ", examDetailResults=" + examDetailResults +
                '}';
    }
}
