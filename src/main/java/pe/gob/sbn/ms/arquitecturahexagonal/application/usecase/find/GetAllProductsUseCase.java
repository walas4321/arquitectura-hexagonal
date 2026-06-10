package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;

public class GetAllProductsUseCase {

    private final ProductRepository repository;

    public GetAllProductsUseCase(
            ProductRepository repository
    ){
        this.repository = repository;
    }

    public Page<Product> execute(int page, int size){

        return repository.findAll(PageRequest.of(page, size));
    }

}
