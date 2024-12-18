package podobnyi.dev.event_manager.users.domain;

public record User(
        Long id,
        String login,
        Integer age,
        UserRole role,
        String passwordHash
) {

}
