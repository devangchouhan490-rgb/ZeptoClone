package com.example.zepto;

import java.util.Objects;

public class Product {

    private String name;
    private int imageResId;
    private String price;
    private String mrp;
    private String quantity;

    public Product(
            String name,
            int imageResId,
            String price,
            String mrp,
            String quantity
    ) {

        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.mrp = mrp;
        this.quantity = quantity;
    }



    // SECOND CONSTRUCTOR

    public Product(
            String name,
            String price,
            String mrp,
            String quantity,
            int imageResId
    ) {

        this.name = name;
        this.price = price;
        this.mrp = mrp;
        this.quantity = quantity;
        this.imageResId = imageResId;
    }



    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPrice() {
        return price;
    }

    public String getMrp() {
        return mrp;
    }

    public String getQuantity() {
        return quantity;
    }



    // IMPORTANT FIX

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        return imageResId == product.imageResId
                && Objects.equals(name, product.name)
                && Objects.equals(price, product.price)
                && Objects.equals(mrp, product.mrp)
                && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                name,
                imageResId,
                price,
                mrp,
                quantity
        );
    }
}