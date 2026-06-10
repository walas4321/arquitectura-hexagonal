package pe.gob.sbn.ms.arquitecturahexagonal.application.mapper;

import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ClientResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;

public class ClientApplicationMapper {

    private ClientApplicationMapper() {
    }

    public static Client toDomain(
            CreateClientRequest request
    ){

        return new Client(
                null,
                request.name(),
                request.lastName(),
                request.adress(),
                request.email(),
                request.phoneNumber(),
                request.fechNac(),
                request.estado()
        );

    }

    public static Client toDomain(
            Long id,
            UpdateClientRequest request
    ) {

        return new Client(
                id,
                request.name(),
                request.email(),
                request.lastName(),
                request.adress(),
                request.phoneNumber(),
                request.fechNac(),
                request.estado()
        );
    }

    public static ClientResponse toResponse(
            Client client
    ) {

        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getEmail(),
                client.getAdress(),
                client.getPhoneNumber(),
                client.getFechNac(),
                client.getEstado()
        );
    }

}
