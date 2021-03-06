package proyecto.escuela.escalab.school.project.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import proyecto.escuela.escalab.school.project.response.ExceptionResponse;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(
            Exception ex, WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ExceptionResponse> manejarModeloException(ConstraintViolationException ex,
                                                                          WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
    }
}


