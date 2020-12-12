package exceptionclass.bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException {
    public LowBalanceBankOperationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public LowBalanceBankOperationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
