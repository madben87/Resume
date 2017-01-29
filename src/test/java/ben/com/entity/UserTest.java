package ben.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_TEST")
public class UserTest implements Comparable<UserTest>{

    private Long id;
    private String name;

    public UserTest() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID_TEST")
    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    @Column(name = "NAME_TEST")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(UserTest u) {
        return id.compareTo(u.getId());
    }
}
