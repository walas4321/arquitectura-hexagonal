package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ProductNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;

public class GetProductByIdUseCase {

    private final ProductRepository repository;

    public GetProductByIdUseCase(
            ProductRepository repository
    ) {
        this.repository = repository;
    }

    public Product execute(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id)
                );
    }

}
