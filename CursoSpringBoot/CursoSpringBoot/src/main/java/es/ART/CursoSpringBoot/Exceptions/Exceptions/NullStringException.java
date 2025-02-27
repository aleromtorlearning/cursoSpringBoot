package es.ART.CursoSpringBoot.Exceptions.Exceptions;

public class NullStringException extends RuntimeException{
    public NullStringException(String mensaje){
        super(mensaje);
    }
}
