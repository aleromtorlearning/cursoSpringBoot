package es.ART.CursoSpringBoot.Exceptions.ExceptionsController;

import es.ART.CursoSpringBoot.Exceptions.Exceptions.EmailInvalidoException;
import es.ART.CursoSpringBoot.Exceptions.Exceptions.NullStringException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (EmailInvalidoException.class)
    public ResponseEntity<String> manejarEmailInvalido(EmailInvalidoException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Formato de email incorrecto");
    }

    @ExceptionHandler (NullStringException.class)
    public ResponseEntity<String> manejarStringsNulos(NullStringException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error string nulo");
    }
}
