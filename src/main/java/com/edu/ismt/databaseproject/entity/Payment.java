package com.edu.ismt.databaseproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "REQUIRED")
    private int tableId;
    @Min(value = 1, message = "Amount should not be 0 or negative")
    private double amount;
    private double discount;
    private String Status;
    private String methodOfPayment;

    public Payment() {
    }

    public Payment(int id, int tableId,int amount, int discount, String status, String methodOfPayment) {
        this.id = id;
        this.tableId=tableId;
        this.amount = amount;
        this.discount = discount;
        Status = status;
        this.methodOfPayment = methodOfPayment;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableID(int tableID) {
        this.tableId = tableID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }
}
