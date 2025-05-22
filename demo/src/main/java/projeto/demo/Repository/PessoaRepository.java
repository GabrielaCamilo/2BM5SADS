package projeto.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.demo.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    UserDetails findByLogin(String role);
}
