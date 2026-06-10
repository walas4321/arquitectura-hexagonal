package pe.gob.sbn.ms.arquitecturahexagonal.domain.validation;

import pe.gob.sbn.ms.arquitecturahexagonal.domain.exception.BusinessException;
import pe.gob.sbn.ms.arquitecturahexagonal.domain.model.Product;

import java.math.BigDecimal;

public class ProductBusinessRules {

    private ProductBusinessRules(){

    }

    public static void validate(Product product){
        validateName(product.getName());
        validatePrice(product.getPrice());
        validateStock(product.getStock());
    }

    public static void validateName(String name) {

        if (name == null || name.isBlank()) {

            throw new BusinessException(
                    "Product name is required"
            );
        }
    }

    public static void validatePrice(BigDecimal price) {

        if (price == null ||
                price.compareTo(BigDecimal.ZERO) <= 0) {

            throw new BusinessException(
                    "Product price must be greater than zero"
            );
        }
    }

    public static void validateStock(Integer stock) {

        if (stock == null || stock < 0) {

            throw new BusinessException(
                    "Invalid stock"
            );
        }
    }


}
