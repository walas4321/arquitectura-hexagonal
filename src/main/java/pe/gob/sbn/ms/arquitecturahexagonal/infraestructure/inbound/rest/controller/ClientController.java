package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.inbound.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.CreateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.request.UpdateClientRequest;
import pe.gob.sbn.ms.arquitecturahexagonal.application.dto.response.ClientResponse;
import pe.gob.sbn.ms.arquitecturahexagonal.application.service.ClientApplicationService;

@RestController
@RequestMapping("/api/clients")
@Tag(
        name = "Clients",
        description = "Client Management API"
)
@RequiredArgsConstructor
public class ClientController {

    private final ClientApplicationService service;

    @Operation(
            summary = "Create client",
            description = "Creates a new client"
    )
    @PostMapping
    public ClientResponse create(
            @Valid @RequestBody
            CreateClientRequest request
    ) {

        return service.create(request);

    }

    @Operation(
            summary = "Update client"
    )
    @PutMapping("/{id}")
    public ClientResponse update(
            @PathVariable Long id,
            @Valid @RequestBody
            UpdateClientRequest request
    ) {

        return service.update(id, request);
    }

    @Operation(
            summary = "Get all clients"
    )
    @GetMapping
    public Page<ClientResponse> getAll(
            @RequestParam(defaultValue = "0")
            int page,
            @RequestParam(defaultValue = "10")
            int size
    ) {

        return service.getAll(page, size);

    }

    @Operation(
            summary = "Delete client"
    )
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        service.delete(id);
    }

}
