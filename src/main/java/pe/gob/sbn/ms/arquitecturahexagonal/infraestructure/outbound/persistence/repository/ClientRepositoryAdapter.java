package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ClientEntity;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.mapper.ClientPersistenceMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final JpaClientRepository repository;

    @Override
    public Client save(Client client) {

        ClientEntity entity =
                ClientPersistenceMapper.toEntity(client);

        ClientEntity saved =
                repository.save(entity);

        return ClientPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<Client> findAll(Pageable pageable) {

        return repository.findAll(pageable)
                .map(ClientPersistenceMapper::toDomain);


    }
}
