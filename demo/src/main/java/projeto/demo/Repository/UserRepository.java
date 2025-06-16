package projeto.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.demo.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByLogin(String login);
}
