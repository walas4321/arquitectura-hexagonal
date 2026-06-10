package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ProductEntity;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByName(String name);
}
