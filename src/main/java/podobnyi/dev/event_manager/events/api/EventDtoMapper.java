package podobnyi.dev.event_manager.events.api;

import org.springframework.stereotype.Component;
import podobnyi.dev.event_manager.events.domain.Event;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event) {
        return new EventDto(
                event.id(),
                event.name(),
                event.ownerId(),
                event.maxPlaces(),
                event.registrationList().size(),
                event.date(),
                event.cost(),
                event.duration(),
                event.locationId(),
                event.status()
        );
    }

}
