package podobnyi.dev.event_manager.events.domain;

public record EventRegistration(
        Long id,
        Long userId,
        Long eventId
) {
}
