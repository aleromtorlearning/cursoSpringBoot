package es.ART.CursoSpringBoot.Clases1a7.Exceptions.Exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String mensaje){
        super(mensaje);
    }
}
