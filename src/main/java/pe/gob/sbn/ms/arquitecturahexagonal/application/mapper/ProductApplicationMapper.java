package pe.gob.sbn.ms.arquitecturahexagonal.application.mapper;

import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ProductResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;

public class ProductApplicationMapper {

    private ProductApplicationMapper() {
    }

    public static Product toDomain(
            CreateProductRequest request
    ){

        return new Product(
                null,
                request.name(),
                request.description(),
                request.price(),
                request.stock()
        );

    }

    public static Product toDomain(
            Long id,
            UpdateProductRequest request
    ) {

        return new Product(
                id,
                request.name(),
                request.description(),
                request.price(),
                request.stock()
        );
    }

    public static ProductResponse toResponse(
            Product product
    ) {

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }

}


