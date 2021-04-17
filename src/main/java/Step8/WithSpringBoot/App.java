package Step8.WithSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private AppRepo appRepo;

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Users users = new Users("Mirana");
        Users_detail users_detail = new Users_detail("Dota2");

        users.setUsers_detail(users_detail);
        users_detail.setUsers(users);

        appRepo.save(users);
    }
}
