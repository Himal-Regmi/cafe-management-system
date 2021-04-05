package com.edu.ismt.databaseproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "REQUIRED")
    private String name;
    private String category;
    @Min(value = 1, message = "Price should not be 0 or negative")
    private int price;
    private String pictureFile;

    public Menu() {
    }

    public Menu(int id, String name, String category, int price, String pictureFile) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.pictureFile = pictureFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }
}
