package pe.gob.sbn.ms.arquitecturahexagonal.domain.model;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Nested;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Nested
    @DisplayName("Tests para actualizar el precio (updatePrice)")
    class UpdatePriceTests {

        @Test
        @DisplayName("Debería cambiar el precio exitosamente cuando el valor es válido")
        void shouldUpdatePrice_WhenPriceIsValid() {
            // Given (Preparación)
            Product product = new Product(1L, "Teclado Mecánico", "RGB Switch Blue", new BigDecimal("150.00"), 20);
            BigDecimal newPrice = new BigDecimal("175.50");

            // When (Acción)
            product.updatePrice(newPrice);

            // Then (Verificación)
            assertEquals(newPrice, product.getPrice(), "El precio no se actualizó correctamente");
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando el nuevo precio es cero")
        void shouldThrowException_WhenPriceIsZero() {
            // Given
            Product product = new Product(1L, "Teclado Mecánico", "RGB", new BigDecimal("150.00"), 20);

            // When & Then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                product.updatePrice(BigDecimal.ZERO);
            });
            assertEquals("Price must be greater than zero", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando el nuevo precio es negativo")
        void shouldThrowException_WhenPriceIsNegative() {
            // Given
            Product product = new Product(1L, "Teclado Mecánico", "RGB", new BigDecimal("150.00"), 20);
            BigDecimal negativePrice = new BigDecimal("-10.50");

            // When & Then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                product.updatePrice(negativePrice);
            });
            assertEquals("Price must be greater than zero", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando el nuevo precio es nulo")
        void shouldThrowException_WhenPriceIsNull() {
            // Given
            Product product = new Product(1L, "Teclado Mecánico", "RGB", new BigDecimal("150.00"), 20);

            // When & Then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                product.updatePrice(null);
            });
            assertEquals("Price must be greater than zero", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests para modificar stock (increaseStock)")
    class StockTests {

        @Test
        @DisplayName("Debería restar del stock exitosamente cuando la cantidad disminuye válidamente")
        void shouldDecreaseStock_WhenQuantityIsValid() {
            // Given
            Product product = new Product(1L, "Mouse Gamer", "Wireless", new BigDecimal("80.00"), 50);

            // When
            product.increaseStock(10); // Nota: Tu lógica interna resta de 'stock' (this.stock -= quantity)

            // Then
            assertEquals(40, product.getStock(), "El stock debió disminuir a 40");
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando el stock resultante quede menor a cero")
        void shouldThrowException_WhenStockBecomesNegative() {
            // Given
            Product product = new Product(1L, "Mouse Gamer", "Wireless", new BigDecimal("80.00"), 15);

            // When & Then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                product.increaseStock(16); // 15 - 16 = -1 (Insuficiente)
            });
            assertEquals("Insufficient stock", exception.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando la cantidad a procesar es cero o negativa")
        void shouldThrowException_WhenQuantityIsZeroOrNegative() {
            // Given
            Product product = new Product(1L, "Mouse Gamer", "Wireless", new BigDecimal("80.00"), 15);

            // When & Then para cantidad cero
            IllegalArgumentException exceptionZero = assertThrows(IllegalArgumentException.class, () -> {
                product.increaseStock(0);
            });
            assertEquals("Quantity must be greater than zero", exceptionZero.getMessage());

            // When & Then para cantidad negativa
            IllegalArgumentException exceptionNegative = assertThrows(IllegalArgumentException.class, () -> {
                product.increaseStock(-5);
            });
            assertEquals("Quantity must be greater than zero", exceptionNegative.getMessage());
        }

        @Test
        @DisplayName("Debería lanzar IllegalArgumentException cuando la cantidad es nula")
        void shouldThrowException_WhenQuantityIsNull() {
            // Given
            Product product = new Product(1L, "Mouse Gamer", "Wireless", new BigDecimal("80.00"), 15);

            // When & Then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                product.increaseStock(null);
            });
            assertEquals("Quantity must be greater than zero", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("Tests para Getters, Setters y Constructores")
    class StructureTests {

        @Test
        @DisplayName("Debería asignar valores correctamente usando los setters tradicionales")
        void shouldSetAndGetPropertiesSuccessfully() {
            // Given
            Product product = new Product();

            // When
            product.setId(10L);
            product.setName("Monitor 27'");
            product.setDescription("4K IPS");

            // Then
            assertEquals(10L, product.getId());
            assertEquals("Monitor 27'", product.getName());
            assertEquals("4K IPS", product.getDescription());
        }
    }

}
