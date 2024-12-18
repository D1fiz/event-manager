package podobnyi.dev.event_manager.users.api;

import jakarta.validation.constraints.NotBlank;

public record SingInRequest(
       @NotBlank
        String login,
        @NotBlank
        String password
) {
}
