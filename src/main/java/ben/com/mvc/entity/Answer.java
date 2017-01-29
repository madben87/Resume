package ben.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "ANSWER")
public class Answer implements Comparable<Answer>{

    private Long answer_id;
    private String answer_message;
    private Message message;

    public Answer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID")
    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    @Column(name = "ANSWER_MESSAGE")
    public String getAnswer_message() {
        return answer_message;
    }

    public void setAnswer_message(String answer_message) {
        this.answer_message = answer_message;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID")
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public int compareTo(Answer a) {
        return answer_id.compareTo(a.answer_id);
    }
}
