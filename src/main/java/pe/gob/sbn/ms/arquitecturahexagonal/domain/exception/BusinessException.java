package pe.gob.sbn.ms.arquitecturahexagonal.domain.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

}
