package YuriLenzi.EsD3Set6.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super(id + " non trovato");
    }
}
