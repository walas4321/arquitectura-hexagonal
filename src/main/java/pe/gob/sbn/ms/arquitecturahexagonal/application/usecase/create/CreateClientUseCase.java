package pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.service.ClientDomainService;

public class CreateClientUseCase {

    private final ClientRepository repository;

    private final ClientDomainService domainService;

    public CreateClientUseCase(
            ClientRepository repository,
            ClientDomainService domainService
    ){
        this.repository = repository;
        this.domainService = domainService;
    }

    public Client execute(Client client){

        domainService.validateClientCreation(client);

        return repository.save(client);

    }

}
