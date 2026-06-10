package pe.gob.sbn.ms.arquitecturahexagonal.domain.exception;

public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException(Long id) {
        super(String.format("Product with id %d not found", id));
    }
}
