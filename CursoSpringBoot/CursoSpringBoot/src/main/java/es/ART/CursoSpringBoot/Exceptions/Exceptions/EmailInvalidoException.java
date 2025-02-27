package es.ART.CursoSpringBoot.Exceptions.Exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String mensaje){
        super(mensaje);
    }
}
