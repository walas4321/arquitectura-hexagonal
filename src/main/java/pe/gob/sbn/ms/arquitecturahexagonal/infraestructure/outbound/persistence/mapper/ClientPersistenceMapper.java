package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.mapper;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;
import pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.outbound.persistence.entity.ClientEntity;

public class ClientPersistenceMapper {

    private ClientPersistenceMapper(){
    }

    public static ClientEntity toEntity(Client client){

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId(client.getId());
        clientEntity.setName(client.getName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setAddress(client.getAdress());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setPhoneNumber(client.getPhoneNumber());
        clientEntity.setFechNac(client.getFechNac());
        clientEntity.setEstado(client.getEstado());
        return clientEntity;
    }

    public static Client toDomain(ClientEntity clientEntity){

        return new Client(
                clientEntity.getId(),
                clientEntity.getName(),
                clientEntity.getEmail(),
                clientEntity.getLastName(),
                clientEntity.getAddress(),
                clientEntity.getPhoneNumber(),
                clientEntity.getFechNac(),
                clientEntity.getEstado()
        );
    }
}
