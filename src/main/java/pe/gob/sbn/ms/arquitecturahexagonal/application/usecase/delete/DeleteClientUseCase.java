package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ClientNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;

public class DeleteClientUseCase {

    private final ClientRepository repository;

    public DeleteClientUseCase(
            ClientRepository repository
    ) {
        this.repository = repository;
    }

    public void execute(Long id) {

        boolean exists =
                repository.findById(id).isPresent();

        if (!exists) {
            throw new ClientNotFoundException(id);
        }

        repository.deleteById(id);
    }

}
