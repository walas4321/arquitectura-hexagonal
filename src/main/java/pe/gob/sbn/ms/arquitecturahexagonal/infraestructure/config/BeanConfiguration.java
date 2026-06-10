package pe.gob.sbn.ms.arquitecturahexagonal.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create.CreateClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.create.CreateProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete.DeleteClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.delete.DeleteProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetAllClientsUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetAllProductsUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetClientByIdUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.find.GetProductByIdUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update.UpdateClientUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.application.usecase.update.UpdateProductUseCase;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ClientRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.service.ClientDomainService;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.service.ProductDomainService;

@Configuration
public class BeanConfiguration {

    @Bean
    public ProductDomainService productDomainService(ProductRepository repository) {
        return new ProductDomainService(repository);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(
        ProductRepository repository,
        ProductDomainService domainService
    ){

        return new CreateProductUseCase(repository, domainService);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(
            ProductRepository repository
    ) {

        return new UpdateProductUseCase(repository);
    }

    @Bean
    public GetProductByIdUseCase getProductByIdUseCase(
            ProductRepository repository
    ) {

        return new GetProductByIdUseCase(repository);
    }

    @Bean
    public GetAllProductsUseCase getAllProductsUseCase(
            ProductRepository repository
    ) {

        return new GetAllProductsUseCase(repository);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase(
            ProductRepository repository
    ) {

        return new DeleteProductUseCase(repository);
    }

    @Bean
    public ClientDomainService clientDomainService(ClientRepository repository) {
        return new ClientDomainService(repository);
    }

    @Bean
    public CreateClientUseCase createClientUseCase(
            ClientRepository repository,
            ClientDomainService domainService
    ){

        return new CreateClientUseCase(repository, domainService);
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase(
            ClientRepository repository
    ){

        return new UpdateClientUseCase(repository);
    }

    @Bean
    public GetClientByIdUseCase getClientByIdUseCase(
            ClientRepository repository
    ) {

        return new GetClientByIdUseCase(repository);
    }

    @Bean
    public GetAllClientsUseCase getAllClientsUseCase(
            ClientRepository repository
    ) {

        return new GetAllClientsUseCase(repository);
    }

    @Bean
    public DeleteClientUseCase deleteClientUseCase(
            ClientRepository repository
    ) {

        return new DeleteClientUseCase(repository);
    }

}
