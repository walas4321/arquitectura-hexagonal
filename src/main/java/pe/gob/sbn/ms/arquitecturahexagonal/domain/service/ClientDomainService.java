package pe.gob.sbn.ms.arquitecturahexagonal.domain.service;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.validation.ClientBusinessRules;

public class ClientDomainService {

    private final ClientRepository clientRepository;

    public ClientDomainService(
            ClientRepository clientRepository
    ){
        this.clientRepository = clientRepository;
    }

    public void validateClientCreation(
            Client client
    ){

        ClientBusinessRules.validate(client);

        validateUniqueEmail(client.getEmail());
    }

    private void validateUniqueEmail(String email) {
        if (clientRepository.existsByEmail(email)) {
            throw new BusinessException("Client with email " + email + " already exists");
        }
    }



}
