package pe.gob.sbn.ms.arquitecturahexagonal.domain.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    boolean existsByName(String name);

    void deleteById(Long id);

    Page<Product> findAll(Pageable pageable);

}
