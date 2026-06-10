package pe.gob.sbn.ms.arquitecturahexagonal.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.repository.ProductRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Inicializa los mocks de Mockito automáticamente
class ProductDomainServiceTest {

    @Mock
    private ProductRepository productRepository; // Simulamos el puerto de salida

    private ProductDomainService productDomainService;

    @BeforeEach
    void setUp() {
        // Inyectamos el mock manualmente a través del constructor
        productDomainService = new ProductDomainService(productRepository);
    }

    @Nested
    @DisplayName("Tests para validación de creación de productos (validateProductCreation)")
    class ValidateProductCreationTests {

        @Test
        @DisplayName("Debería pasar la validación exitosamente cuando el producto cumple todas las reglas y el nombre es único")
        void shouldPassValidation_WhenProductIsValidAndNameIsUnique() {
            // Given
            Product validProduct = new Product(null, "Teclado Mecánico", "RGB Switch Red", new BigDecimal("250.00"), 10);

            // Configuramos el comportamiento del mock: cuando pregunten si existe el nombre, responde false
            when(productRepository.existsByName("Teclado Mecánico")).thenReturn(false);

            // When & Then
            assertDoesNotThrow(() -> productDomainService.validateProductCreation(validProduct));

            // Verificamos que el servicio realmente consultó al repositorio exactamente una vez
            verify(productRepository, times(1)).existsByName("Teclado Mecánico");
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el nombre del producto ya existe en el repositorio")
        void shouldThrowException_WhenProductNameAlreadyExists() {
            // Given
            Product duplicateProduct = new Product(null, "Monitor 24'", "Full HD", new BigDecimal("550.00"), 5);

            // Configuramos el mock para que simule que el nombre ya está registrado
            when(productRepository.existsByName("Monitor 24'")).thenReturn(true);

            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                productDomainService.validateProductCreation(duplicateProduct);
            });

            assertEquals("Product with name Monitor 24' already exists", exception.getMessage());
            verify(productRepository, times(1)).existsByName("Monitor 24'");
        }

        @Test
        @DisplayName("Debería lanzar BusinessException por reglas de formato antes de consultar al repositorio si el producto es inválido")
        void shouldThrowException_WhenProductFailsBusinessRulesFields() {
            // Given (Precio inválido de cero, lo cual infringe ProductBusinessRules)
            Product invalidProduct = new Product(null, "Mouse Gamer", "Wireless", BigDecimal.ZERO, 15);

            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                productDomainService.validateProductCreation(invalidProduct);
            });

            assertEquals("Product price must be greater than zero", exception.getMessage());

            // Cortocircuito de seguridad: Como falló la validación estática de campos,
            // el flujo debió detenerse y NUNCA debió consultar a la base de datos (repositorio).
            verify(productRepository, never()).existsByName(anyString());
        }
    }

}
