package pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.enums.ClientStatus;

import java.time.LocalDate;

public record ClientResponse(

        Long id,

        String name,

        String lastName,

        String address,

        String email,

        String phoneNumber,

        LocalDate fechNac,

        ClientStatus estado

) {
}
