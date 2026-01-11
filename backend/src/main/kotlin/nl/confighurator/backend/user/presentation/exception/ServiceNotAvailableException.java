package nl.confighurator.backend.user.presentation.exception;

public class ServiceNotAvailableException extends RuntimeException {
    public ServiceNotAvailableException(String message){
        super(message);
    }
}
