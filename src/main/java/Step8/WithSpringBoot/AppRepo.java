package Step8.WithSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<Users,Long> {
}
