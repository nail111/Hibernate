package Step8.WithSpringBoot;

import javax.persistence.*;

@Entity
public class Users {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "users_detail_id")
    private Users_detail users_detail;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Users_detail getUsers_detail() {
        return users_detail;
    }

    public void setUsers_detail(Users_detail users_detail) {
        this.users_detail = users_detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
