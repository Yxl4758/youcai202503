package Exception_Test._01Test;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super();
    }
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
