package dds.grupo3.clases.exception;

public class ArchivoNoEncontradoException extends RuntimeException {
    public ArchivoNoEncontradoException(){
        super("El archivo no ha encontrado");
    }
}