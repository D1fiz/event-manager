package podobnyi.dev.event_manager.locations;

public record LocationDto(
        Long id,
        String name,
        String address,
        Long capacity,
        String description
) {
}
