package podobnyi.dev.event_manager.web;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handlerCommonException(Exception exception) {
        log.error("Handler common exception", exception);
        ErrorMassageResponse massageResponse = new ErrorMassageResponse("Internal error", exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(500).body(massageResponse);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handlerNotFound(Exception exception) {
        log.error("Handler entity not found exception", exception);
        ErrorMassageResponse massageResponse = new ErrorMassageResponse("Entity not found", exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(404).body(massageResponse);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handlerIllegalArgument(Exception exception) {
        log.error("Handler bad request exception", exception);
        ErrorMassageResponse massageResponse = new ErrorMassageResponse("Bad request", exception.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(400).body(massageResponse);
    }
}
