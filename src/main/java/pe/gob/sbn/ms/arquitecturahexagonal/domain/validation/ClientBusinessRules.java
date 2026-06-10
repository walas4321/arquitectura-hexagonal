package pe.gob.sbn.ms.arquitecturahexagonal.domain.validation;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Client;

public class ClientBusinessRules {

    public ClientBusinessRules(){}

    public static void validate(Client client){
        validateName(client.getName());
        validateEmail(client.getEmail());
    }

    public static void validateName(String name) {

        if (name == null || name.isBlank()) {
            throw new BusinessException("Client name is required");
        }

    }

    public static void validateEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new BusinessException("Client email is required");
        }

        if (!email.contains("@")) {
            throw new BusinessException("Invalid email format");
        }
    }
}
