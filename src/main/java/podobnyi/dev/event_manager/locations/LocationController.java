package podobnyi.dev.event_manager.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final static Logger log= LoggerFactory.getLogger(LocationController.class);


    @PostMapping()
    public ResponseEntity<LocationDto> createLocation(
            @RequestBody LocationDto locationDto
    ) {
        log.info("Get request for location create: locationDto={}",locationDto);
        return ResponseEntity.ok(locationDto);
    }
}

