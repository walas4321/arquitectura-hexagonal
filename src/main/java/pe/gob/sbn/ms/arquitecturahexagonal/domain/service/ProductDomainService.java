package pe.gob.sbn.ms.arquitecturahexagonal.domain.service;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.validation.ProductBusinessRules;

public class ProductDomainService {

    private final ProductRepository productRepository;

    public ProductDomainService(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    public void validateProductCreation(
            Product product
    ) {

        ProductBusinessRules.validate(product);

        validateUniqueName(product.getName());
    }

    private void validateUniqueName(String name) {
        if (productRepository.existsByName(name)) {
            throw new BusinessException("Product with name " + name + " already exists");
        }
    }

}
