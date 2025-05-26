package mx.unam.aragon.ico.te.proyecto_is.excepciones;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private HashMap<String, String> buildResponse(String code, String message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("message", message);
        response.put("code", code);
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(buildResponse("2001", "Error de validación en los argumentos."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> handleUnreadable(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(buildResponse("2002", "JSON mal formado o estructura incorrecta."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<HashMap<String, String>> handleMissingParams(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(buildResponse("2003", "Falta un parámetro obligatorio en la petición."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<HashMap<String, String>> handleConstraintViolation(ConstraintViolationException ex) {
        return new ResponseEntity<>(buildResponse("2004", "Restricción de base de datos violada (valor duplicado, nulo, etc.)."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(buildResponse("2005", "El recurso solicitado no existe."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<HashMap<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>(buildResponse("2006", "Argumento inválido recibido."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HashMap<String, String>> handleGeneric(Exception ex) {
        return new ResponseEntity<>(buildResponse("5000", "Error interno no controlado: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
