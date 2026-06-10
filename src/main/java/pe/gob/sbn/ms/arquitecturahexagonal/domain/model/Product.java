package pe.gob.sbn.ms.arquitecturahexagonal.domain.model;

import java.math.BigDecimal;

public class Product {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    public Product() {
    }

    public Product(
            Long id,
            String name,
            String description,
            BigDecimal price,
            Integer stock
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    /*
     * Business logic methods
     */
    public void updatePrice(BigDecimal newPrice){

        validatePrice(newPrice);

        this.price = newPrice;
    }

    public void increaseStock(Integer quantity){

        validateQuantity(quantity);

        if(this.stock - quantity < 0){
            throw new IllegalArgumentException(
                    "Insufficient stock"
            );
        }

        this.stock -= quantity;
    }

    /*
     * Validation methods
     */
    private void validatePrice(BigDecimal price) {

        if (price == null ||
                price.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Price must be greater than zero"
            );
        }
    }

    private void validateQuantity(Integer quantity){

        if(quantity == null || quantity <= 0){
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }
    }

    /*
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }





}