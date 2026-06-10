package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.ClientNotFoundException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;

public class GetClientByIdUseCase {

    private final ClientRepository repository;

    public GetClientByIdUseCase(
            ClientRepository repository
    ){
        this.repository = repository;
    }

    public Client execute(Long id){

        return repository.findById(id)
                .orElseThrow(() ->
                        new ClientNotFoundException(id)
                );
    }

}
