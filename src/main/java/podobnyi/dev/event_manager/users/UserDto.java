package podobnyi.dev.event_manager.users;

public record UserDto(
        Long id,
        String login,
        Integer age,
        UserRole role) {
}
