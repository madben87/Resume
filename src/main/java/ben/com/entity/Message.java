package ben.com.entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "MESSAGE")
public class Message implements Comparable<Message>{

    private Long message_id;
    private String message;
    private String message_status;
    private DateTime date;
    private User user;
    private Set<Answer> answers_list;

    public Message() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "MESSAGES_STATUS")
    public String getMessage_status() {
        return message_status;
    }

    public void setMessage_status(String message_status) {
        this.message_status = message_status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID"/*, insertable = false, updatable = false*/)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Answer> getAnswers_list() {
        return answers_list;
    }

    public void setAnswers_list(Set<Answer> answers_list) {
        this.answers_list = answers_list;
    }

    @Override
    public int compareTo(Message m) {
        return message_id.compareTo(m.getMessage_id());
    }
}
