package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.mapper;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ProductEntity;

public class ProductPersistenceMapper {

    private ProductPersistenceMapper() {
    }

    public static ProductEntity toEntity(Product product){

        ProductEntity entity = new ProductEntity();

        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setStock(product.getStock());

        return entity;
    }

    public static Product toDomain(ProductEntity entity){

        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getStock()
        );
    }


}
