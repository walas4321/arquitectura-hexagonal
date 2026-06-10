package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ProductNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;

public class UpdateProductUseCase {

    private final ProductRepository repository;

    public UpdateProductUseCase(
            ProductRepository repository)
    {
        this.repository = repository;
    }

    public Product execute(Product product){

        Product existing =
                repository.findById(product.getId())
                        .orElseThrow(() ->
                                new ProductNotFoundException(
                                        product.getId()
                                )
                        );

        existing.updatePrice(product.getPrice());
        existing.increaseStock(product.getStock());

        return repository.save(existing);

    }

}
