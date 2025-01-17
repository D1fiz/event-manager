package podobnyi.dev.event_manager.events.api;

import podobnyi.dev.event_manager.events.domain.EventStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventSearchFilter(
        String name,
        Integer palaceMin,
        Integer palaceMax,
        LocalDateTime dateStartAfter,
        LocalDateTime dateStartBefore,
        BigDecimal costMin,
        BigDecimal costMax,
        Integer durationMin,
        Integer durationMax,
        Integer locationId,
        EventStatus eventStatus
        ) {

}
