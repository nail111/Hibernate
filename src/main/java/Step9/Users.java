package Step9;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "users",fetch = FetchType.LAZY)
    private List<UsersDetail> usersDetailList;

    public List<UsersDetail> getUsersDetailList() {
        return usersDetailList;
    }

    public void setUsersDetailList(List<UsersDetail> usersDetailList) {
        this.usersDetailList = usersDetailList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Users(String name) {
        this.name = name;
    }

    public Users() {
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
