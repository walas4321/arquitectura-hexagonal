package pe.gob.sbn.ms.arquitecturahexagonal.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client save(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    boolean existsByEmail(String email);

    void deleteById(Long id);

    Page<Client> findAll(Pageable pageable);

}
