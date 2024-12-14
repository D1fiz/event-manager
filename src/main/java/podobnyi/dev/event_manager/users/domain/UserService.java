package podobnyi.dev.event_manager.users.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import podobnyi.dev.event_manager.users.db.UserEntityMapper;
import podobnyi.dev.event_manager.users.db.UserRepository;

@Service
public class UserService {
    private final static Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserService(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    public User saveUser(User user){
        log.info("Save user:user={}",user);
        var entity=userEntityMapper.toEntity(user);
       var savedUser= userRepository.save(entity);
        return userEntityMapper.toDomain(savedUser);
    }
    public boolean isUserExistByLogin(String login){
        return userRepository.findByLogin(login).isPresent();
    }
}
