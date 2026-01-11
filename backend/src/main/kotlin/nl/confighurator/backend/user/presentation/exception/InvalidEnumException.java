package nl.confighurator.backend.user.presentation.exception;

public class InvalidEnumException extends RuntimeException {
  public InvalidEnumException(String message) {
    super(message);
  }
}
