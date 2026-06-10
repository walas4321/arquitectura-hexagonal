package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;

public class GetAllClientsUseCase {

    private final ClientRepository repository;

    public GetAllClientsUseCase(
            ClientRepository repository
    ){
        this.repository = repository;
    }

    public Page<Client> execute(int page, int size){

        return repository.findAll(PageRequest.of(page, size));

    }

}
