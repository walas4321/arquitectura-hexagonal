package pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateProductRequest(

        @NotBlank(message = "Name is required")
        String name,

        String description,

        @NotNull(message = "Price is required")
        BigDecimal price,

        @NotNull(message = "Stock is required")
        Integer stock

) {
}
