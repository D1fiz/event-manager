package podobnyi.dev.event_manager.users.api;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import podobnyi.dev.event_manager.users.domain.AuthenticationService;
import podobnyi.dev.event_manager.users.domain.User;
import podobnyi.dev.event_manager.users.domain.UserRegistrationService;
import podobnyi.dev.event_manager.users.domain.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final UserRegistrationService userRegistrationService;


    public UserController(UserService userService, AuthenticationService authenticationService, UserRegistrationService userRegistrationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.userRegistrationService = userRegistrationService;

    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(
            @RequestBody @Valid SignUpRequest signUpRequest
    ){
        log.info("Get request for sign-un: login={}", signUpRequest.login());
      var user=  userRegistrationService.registerUser(signUpRequest);


      return ResponseEntity.status(201).body(convertDomainUser(user));
    }

    @PostMapping("/auth")
    public ResponseEntity<JwtTokenResponse> authenticate(@RequestBody @Valid SingInRequest singInRequest){

      log.info("Get request for authenticate user,login={}",singInRequest.login());
      var token=authenticationService.authenticateUser(singInRequest);
      return ResponseEntity.ok(new JwtTokenResponse(token));
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
