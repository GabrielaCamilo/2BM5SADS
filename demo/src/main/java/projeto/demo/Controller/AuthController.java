package projeto.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.demo.Model.Users;
import projeto.demo.Repository.UserRepository;
import projeto.demo.Service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Users users){
        var usernamePassword=new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword(), users.getAuthorities());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token=tokenService.generateToken((Users)auth.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Users users){
        if(this.userRepository.findByLogin(users.getUsername())!=null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword=new BCryptPasswordEncoder().encode(users.getPassword());
        Users newUsers =new Users(users.getUsername(),encryptedPassword, users.getRole());
        this.userRepository.save(newUsers);
        return ResponseEntity.ok().build();
    }
}