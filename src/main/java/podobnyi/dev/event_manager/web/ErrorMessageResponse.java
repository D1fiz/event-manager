package podobnyi.dev.event_manager.web;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ErrorMessageResponse(
        String message,
        String detailedMessage,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        LocalDateTime dateTime
) {
}
