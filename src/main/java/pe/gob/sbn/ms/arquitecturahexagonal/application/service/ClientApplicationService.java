package pe.gob.sbn.ms.arquitecturahexagonal.application.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ClientResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.application.mapper.ClientApplicationMapper;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create.CreateClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete.DeleteClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetAllClientsUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetClientByIdUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update.UpdateClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;

@Service
@Transactional
public class ClientApplicationService {

    private final CreateClientUseCase createUseCase;

    private final UpdateClientUseCase updateUseCase;

    private final GetClientByIdUseCase getByIdUseCase;

    private final GetAllClientsUseCase getAllUseCase;

    private final DeleteClientUseCase deleteUseCase;

    public ClientApplicationService(
            CreateClientUseCase createUseCase,
            UpdateClientUseCase updateUseCase,
            GetClientByIdUseCase getByIdUseCase,
            GetAllClientsUseCase getAllUseCase,
            DeleteClientUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.getAllUseCase = getAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    public ClientResponse create(CreateClientRequest request){

        Client client = ClientApplicationMapper.toDomain(request);

        Client saved = createUseCase.execute(client);

        return ClientApplicationMapper.toResponse(saved);

    }

    public ClientResponse update(Long id, UpdateClientRequest request){

        Client client = ClientApplicationMapper.toDomain(id, request);

        Client updated = this.updateUseCase.execute(client);

        return ClientApplicationMapper.toResponse(updated);

    }

    @Transactional(readOnly = true)
    public Page<ClientResponse> getAll(int page, int size) {

        Page<Client> clients =
                getAllUseCase.execute(page, size);

        return clients.map(
                ClientApplicationMapper::toResponse
        );

    }

    public void delete(Long id) {

        deleteUseCase.execute(id);

    }



}
