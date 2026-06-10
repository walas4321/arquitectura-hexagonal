package pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Schema(
        description = "Request for creating product"
)
public record CreateProductRequest(

        @Schema(
                description = "Product name",
                example = "Laptop Lenovo"
        )
        @NotBlank(message = "Name is required")
        String name,

        @Schema(
                description = "Product description",
                example = "Gaming laptop"
        )
        String description,

        @Schema(
                description = "Product price",
                example = "4500.99"
        )
        @NotNull(message = "Price is required")
        BigDecimal price,

        @Schema(
                description = "Available stock",
                example = "10"
        )
        @NotNull(message = "Stock is required")
        Integer stock

) {
}
