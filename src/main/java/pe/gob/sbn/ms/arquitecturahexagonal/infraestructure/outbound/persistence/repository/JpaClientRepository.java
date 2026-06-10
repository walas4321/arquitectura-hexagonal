package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ClientEntity;

public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(String email);

}
