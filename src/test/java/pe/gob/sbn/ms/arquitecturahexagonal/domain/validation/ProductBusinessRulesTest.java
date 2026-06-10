package pe.gob.sbn.ms.arquitecturahexagonal.domain.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductBusinessRulesTest {

    @Nested
    @DisplayName("Tests para el validador general (validate)")
    class GeneralValidateTests {

        @Test
        @DisplayName("Debería pasar la validación sin lanzar excepciones cuando el producto es completamente válido")
        void shouldPassValidation_WhenProductIsValid() {
            // Given
            Product validProduct = new Product(1L, "Laptop ASUS", "Intel i7", new BigDecimal("3500.00"), 15);

            // When & Then
            // assertDoesNotThrow verifica que el bloque de código no dispare ninguna excepción
            assertDoesNotThrow(() -> ProductBusinessRules.validate(validProduct));
        }

        @Test
        @DisplayName("Debería lanzar BusinessException al validar un producto si falla la primera regla (Nombre)")
        void shouldThrowException_WhenProductHasInvalidName() {
            // Given (Nombre vacío)
            Product invalidProduct = new Product(1L, "   ", "Intel i7", new BigDecimal("3500.00"), 15);

            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validate(invalidProduct);
            });
            assertEquals("Product name is required", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests para la validación del nombre (validateName)")
    class ValidateNameTests {

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el nombre es nulo")
        void shouldThrowException_WhenNameIsNull() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validateName(null);
            });
            assertEquals("Product name is required", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el nombre está vacío")
        void shouldThrowException_WhenNameIsEmpty() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validateName("");
            });
            assertEquals("Product name is required", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el nombre contiene solo espacios en blanco")
        void shouldThrowException_WhenNameIsBlank() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validateName("     ");
            });
            assertEquals("Product name is required", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests para la validación del precio (validatePrice)")
    class ValidatePriceTests {

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el precio es nulo")
        void shouldThrowException_WhenPriceIsNull() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validatePrice(null);
            });
            assertEquals("Product price must be greater than zero", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el precio es exactamente cero")
        void shouldThrowException_WhenPriceIsZero() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validatePrice(BigDecimal.ZERO);
            });
            assertEquals("Product price must be greater than zero", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el precio es un valor negativo")
        void shouldThrowException_WhenPriceIsNegative() {
            // When & Then
            BigDecimal negativePrice = new BigDecimal("-0.01");
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validatePrice(negativePrice);
            });
            assertEquals("Product price must be greater than zero", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests para la validación del stock (validateStock)")
    class ValidateStockTests {

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el stock es nulo")
        void shouldThrowException_WhenStockIsNull() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validateStock(null);
            });
            assertEquals("Invalid stock", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar BusinessException cuando el stock es un número negativo")
        void shouldThrowException_WhenStockIsNegative() {
            // When & Then
            BusinessException exception = assertThrows(BusinessException.class, () -> {
                ProductBusinessRules.validateStock(-1);
            });
            assertEquals("Invalid stock", exception.getMessage());
        }

        @Test
        @DisplayName("Debería permitir la validación cuando el stock es exactamente cero")
        void shouldPass_WhenStockIsZero() {
            // En tu lógica, un stock de 0 es válido (stock < 0 es el inválido)
            assertDoesNotThrow(() -> ProductBusinessRules.validateStock(0));
        }
    }

}