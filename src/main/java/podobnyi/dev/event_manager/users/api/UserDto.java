package podobnyi.dev.event_manager.users.api;

import podobnyi.dev.event_manager.users.domain.UserRole;

public record UserDto(
        Long id,
        String login,
        Integer age,
        UserRole role) {
}
