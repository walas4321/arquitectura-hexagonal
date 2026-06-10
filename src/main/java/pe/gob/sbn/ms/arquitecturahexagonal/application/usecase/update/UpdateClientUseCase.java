package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ClientNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;

public class UpdateClientUseCase {

    private final ClientRepository repository;

    public UpdateClientUseCase(
            ClientRepository repository)
    {
        this.repository = repository;
    }

    public Client execute(Client client) {

        Client existing =
                repository.findById(client.getId())
                        .orElseThrow(() ->
                                new ClientNotFoundException(
                                        client.getId()
                                )
                        );

        return repository.save(existing);
    }

}
