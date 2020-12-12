
package exceptionclass.bank;

enum ErrorCode {
    LOW_BALANCE, INVALID_AMOUNT, INVALID_ACCOUNTNUMBER
}

public class InvalidBankOperationException extends RuntimeException {
    private ErrorCode errorCode;

    public InvalidBankOperationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public InvalidBankOperationException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
