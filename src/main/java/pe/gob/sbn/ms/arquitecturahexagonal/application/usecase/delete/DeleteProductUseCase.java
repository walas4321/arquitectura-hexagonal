package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ProductNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;

public class DeleteProductUseCase {

    private final ProductRepository repository;

    public DeleteProductUseCase(
            ProductRepository repository
    ) {
        this.repository = repository;
    }

    public void execute(Long id) {

        boolean exists =
                repository.findById(id).isPresent();

        if (!exists) {
            throw new ProductNotFoundException(id);
        }

        repository.deleteById(id);
    }

}
