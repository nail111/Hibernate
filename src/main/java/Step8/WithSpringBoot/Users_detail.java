package Step8.WithSpringBoot;

import javax.persistence.*;

@Entity
public class Users_detail {

    @OneToOne(mappedBy = "users_detail",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Users users;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastname;

    public Users_detail() {
    }

    public Users_detail(String lastname) {
        this.lastname = lastname;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
