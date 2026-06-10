package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.inbound.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateProductRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ProductResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.application.service.ProductApplicationService;

@RestController
@RequestMapping("/api/products")
@Tag(
        name = "Products",
        description = "Product Management API"
)
@RequiredArgsConstructor
public class ProductController {

    private final ProductApplicationService service;

    @Operation(
            summary = "Create product",
            description = "Creates a new product"
    )
    @PostMapping
    public ProductResponse create(
            @Valid @RequestBody
            CreateProductRequest request
    ) {

        return service.create(request);
    }

    @Operation(
            summary = "Update product"
    )
    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @Valid @RequestBody
            UpdateProductRequest request
    ) {

        return service.update(id, request);
    }

    @Operation(
            summary = "Get all products"
    )
    @GetMapping
    public Page<ProductResponse> getAll(
        @RequestParam(defaultValue = "0")
        int page,
        @RequestParam(defaultValue = "10")
        int size
    ) {

        return service.getAll(page, size);

    }

    @Operation(
            summary = "Delete product"
    )
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        service.delete(id);
    }

}
