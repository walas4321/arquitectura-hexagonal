package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ProductEntity;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.mapper.ProductPersistenceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository repository;

    @Override
    public Product save(Product product) {

        ProductEntity entity =
                ProductPersistenceMapper.toEntity(product);

        ProductEntity saved =
                repository.save(entity);

        return ProductPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(Long id) {

        return repository.findById(id)
                .map(ProductPersistenceMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll()
                .stream()
                .map(ProductPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByName(String name) {

        return repository.existsByName(name);
    }

    @Override
    public void deleteById(Long id) {

        repository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(ProductPersistenceMapper::toDomain);
    }
}
