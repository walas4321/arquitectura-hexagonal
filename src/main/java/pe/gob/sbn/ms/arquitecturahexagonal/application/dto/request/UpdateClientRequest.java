package pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.enums.ClientStatus;

import java.time.LocalDate;

public record UpdateClientRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Address is required")
        String adress,

        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Phone number is required")
        String phoneNumber,

        @NotBlank(message = "Date of birth is required")
        LocalDate fechNac,

        @NotBlank(message = "Status is required")
        ClientStatus estado

) {
}
