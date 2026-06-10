package pe.gob.sbn.ms.arquitecturahexagonal.application.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ProductResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.application.mapper.ProductApplicationMapper;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create.CreateProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete.DeleteProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetAllProductsUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetProductByIdUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update.UpdateProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;

@Service
@Transactional
public class ProductApplicationService {

    private final CreateProductUseCase createUseCase;

    private final UpdateProductUseCase updateUseCase;

    private final GetProductByIdUseCase getByIdUseCase;

    private final GetAllProductsUseCase getAllUseCase;

    private final DeleteProductUseCase deleteUseCase;

    public ProductApplicationService(
            CreateProductUseCase createUseCase,
            UpdateProductUseCase updateUseCase,
            GetProductByIdUseCase getByIdUseCase,
            GetAllProductsUseCase getAllUseCase,
            DeleteProductUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.getAllUseCase = getAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    public ProductResponse create(CreateProductRequest request){

        Product product = ProductApplicationMapper.toDomain(request);

        Product saved = createUseCase.execute(product);

        return ProductApplicationMapper.toResponse(saved);
    }

    public ProductResponse update(Long id, UpdateProductRequest request){

        Product product = ProductApplicationMapper.toDomain(id, request);

        Product updated = updateUseCase.execute(product);

        return ProductApplicationMapper.toResponse(updated);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> getAll(int page, int size){

        Page<Product> products =
                getAllUseCase.execute(page, size);

        return products.map(
                ProductApplicationMapper::toResponse
        );

        /*
        return getAllUseCase.execute()
                .stream()
                .map(ProductApplicationMapper::toResponse)
                .toList();

         */
    }

    public void delete(Long id){

        deleteUseCase.execute(id);
     }


}
