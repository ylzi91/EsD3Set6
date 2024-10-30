package YuriLenzi.EsD3Set6.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super(id + " non trovato");
    }
}
