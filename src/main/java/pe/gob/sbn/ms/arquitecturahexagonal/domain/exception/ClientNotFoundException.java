package pe.gob.sbn.ms.arquitecturahexagonal.domain.exception;

public class ClientNotFoundException extends BusinessException {

    public ClientNotFoundException(Long id) {
        super(String.format("Client with id %d not found", id));
    }

}
