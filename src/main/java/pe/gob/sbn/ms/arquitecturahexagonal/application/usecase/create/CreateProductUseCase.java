package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.service.ProductDomainService;

public class CreateProductUseCase {

    private final ProductRepository repository;

    private final ProductDomainService domainService;

    public CreateProductUseCase(
            ProductRepository repository,
            ProductDomainService domainService)
    {
        this.repository = repository;
        this.domainService = domainService;

    }

    public Product execute(Product product){

        domainService.validateProductCreation(product);

        return repository.save(product);
    }

}
