package podobnyi.dev.event_manager.users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(SignInRequest signInRequest) {
        if (userService.isUserExistByLogin(signInRequest.login())) {
            throw new IllegalArgumentException("User with such login already exists");
        }
        var hashedPass = passwordEncoder.encode(signInRequest.password());
        var user = new User(
                null,
                signInRequest.login(),
                signInRequest.age(),
                UserRole.USER,
                hashedPass
        );
        return userService.saveUser(user);

    }
}
