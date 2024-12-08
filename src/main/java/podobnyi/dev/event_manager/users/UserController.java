package podobnyi.dev.event_manager.users;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserRegistrationService userRegistrationService;

    public UserController(UserService userService, UserRegistrationService userRegistrationService) {
        this.userService = userService;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(
            @RequestBody @Valid SignInRequest signInRequest
    ){
        log.info("Get request for sign-un: login={}",signInRequest.login());
      var user=  userRegistrationService.registerUser(signInRequest);
      return ResponseEntity.status(201).body(convertDomainUser(user));
    }



    private UserDto convertDomainUser(User user){
        return new UserDto(
                user.id(),
                user.login(),
                user.age(),
                user.role()
        );
    }
}
