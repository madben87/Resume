package ben.com.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements Comparable<User>{

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Set<Message> messages_list;

    public User() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Message> getMessages_list() {
        return messages_list;
    }

    public void setMessages_list(Set<Message> messages_list) {
        this.messages_list = messages_list;
    }

    @Override
    public int compareTo(User u) {
        return id.compareTo(u.getId());
    }
}
