package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.inbound.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleBusinessException(
            BusinessException ex
    ) {

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(
            HttpStatus.INTERNAL_SERVER_ERROR
    )
    public Map<String, Object> handleException(
            Exception ex
    ) {

        return Map.of(
                "timestamp", LocalDateTime.now(),
                "message", ex.getMessage()
        );
    }

}
