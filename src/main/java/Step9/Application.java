package Step9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AppRepo appRepo;


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Users users = new Users("Johhny");

        UsersDetail usersDetail1 = new UsersDetail("Depp");
        UsersDetail usersDetail2 = new UsersDetail("NotDepp");

        List<UsersDetail> usersDetailList = new ArrayList<UsersDetail>();
        usersDetailList.add(usersDetail1);
        usersDetailList.add(usersDetail2);

        users.setUsersDetailList(usersDetailList);
        usersDetail1.setUsers(users);
        usersDetail2.setUsers(users);

        appRepo.save(users);
    }
}
