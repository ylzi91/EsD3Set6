package YuriLenzi.EsD3Set6.exceptions;

public class SameEmailException extends RuntimeException {
    public SameEmailException(String email) {
        super(
                email + " è già presente"
        );
    }
}
