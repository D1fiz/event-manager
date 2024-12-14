package podobnyi.dev.event_manager.users.api;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import podobnyi.dev.event_manager.security.JwtTokenManager;
import podobnyi.dev.event_manager.users.domain.User;
import podobnyi.dev.event_manager.users.domain.UserRegistrationService;
import podobnyi.dev.event_manager.users.domain.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final UserRegistrationService userRegistrationService;

    private final JwtTokenManager jwtTokenManager;

    public UserController(UserService userService, UserRegistrationService userRegistrationService, JwtTokenManager jwtTokenManager) {
        this.userService = userService;
        this.userRegistrationService = userRegistrationService;
        this.jwtTokenManager = jwtTokenManager;
    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(
            @RequestBody @Valid SignUpRequest signUpRequest
    ){
        log.info("Get request for sign-un: login={}", signUpRequest.login());
      var user=  userRegistrationService.registerUser(signUpRequest);


      var token=jwtTokenManager.generateToken(user);
      log.info("token = {}",token);
      log.info("valid = {}",jwtTokenManager.isTokenValid(token));
      log.info("login = {}",jwtTokenManager.getLoginFromToken(token));

      return ResponseEntity.status(201).body(convertDomainUser(user));
    }

    @PostMapping("/auth")
    public ResponseEntity<JwtTokenResponse> authenticate(@RequestBody @Valid SingInRequest singInRequest){

      log.info("Get request for authenticate user,login={}",singInRequest.login());
    return null;
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
