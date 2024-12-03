package podobnyi.dev.event_manager.web;

import java.time.LocalDateTime;

public record ErrorMassageResponse(
        String message,
        String detailedMessage,
        LocalDateTime dateTime
        ) {
}
