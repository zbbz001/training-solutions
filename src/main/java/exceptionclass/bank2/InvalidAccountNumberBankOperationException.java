package exceptionclass.bank2;

public class InvalidAccountNumberBankOperationException extends InvalidBankOperationException {

    public InvalidAccountNumberBankOperationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InvalidAccountNumberBankOperationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
