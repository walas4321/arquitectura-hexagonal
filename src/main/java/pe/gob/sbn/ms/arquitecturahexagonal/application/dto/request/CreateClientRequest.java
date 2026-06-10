package pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.enums.ClientStatus;

import java.time.LocalDate;

public record CreateClientRequest(

        @Schema(
                description = "Client name",
                example = "John Doe"
        )
        @NotBlank(message = "Name is required")
        String name,

        @Schema(
                description = "Client last name",
                example = "Smith"
        )
        @NotBlank(message = "Last name is required")
        String lastName,

        @Schema(
                description = "Client address",
                example = "123 Main St, City, Country"
        )
        String adress,

        @Schema(
                description = "Client email",
                example = "john.doe@example.com"
        )
        String email,

        @Schema(
                description = "Client phone number",
                example = "+1 555-123-4567"
        )
        String phoneNumber,

        @Schema(
                description = "Client date of birth",
                example = "1990-01-01"
        )
        LocalDate fechNac,

        @Schema(
                description = "Client status",
                example = "ACTIVE"
        )
        ClientStatus estado

) {
}
