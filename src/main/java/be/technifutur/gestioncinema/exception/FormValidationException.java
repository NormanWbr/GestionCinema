package be.technifutur.gestioncinema.exception;

public class FormValidationException extends RuntimeException {
    public FormValidationException(String message) {
        super(message);
    }
}