package podobnyi.dev.event_manager.locations;

public record Location(
        Long id,
        String name,
        String address,
        Long capacity,
        String description) {

}
