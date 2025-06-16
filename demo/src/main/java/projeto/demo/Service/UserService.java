package projeto.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projeto.demo.Model.Users;
import projeto.demo.Repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    public Users getUserById(int id) {
        return userRepository.findById((long) id).orElseThrow();
    }

    public Users updateUser(String username, Users users) {
        Users oldUsers = (Users) userRepository.findByLogin(username);

        oldUsers.setLogin(users.getLogin());
        oldUsers.setPassword(users.getPassword());
        return userRepository.save(oldUsers);
    }

    public Users updateUserById(int id, Users users) {
        Users oldUsers = userRepository.findById((long) id).orElseThrow();

        oldUsers.setLogin(users.getLogin());
        oldUsers.setPassword(users.getPassword());
        return userRepository.save(oldUsers);
    }

    public Users deleteUser(int id) {
        Users oldUsers = userRepository.findById((long) id).orElseThrow();
        userRepository.delete(oldUsers);
        return oldUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}