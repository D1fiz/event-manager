package podobnyi.dev.event_manager.users;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SignInRequest(
        @NotBlank
        String login,
        @NotBlank
        String password,
        @Min(18)
        Integer age
        ) {
}
