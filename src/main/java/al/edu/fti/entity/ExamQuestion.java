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

    @Column(name = "order_item")
    private Integer order;

    @Column(name = "visibility")
    private Boolean visibility;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "exam_id")
    private Exam exam;

    @OneToMany(mappedBy = "examQuestion", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ExamDetailResult> examDetailResults;

    public ExamQuestion() {
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

}
