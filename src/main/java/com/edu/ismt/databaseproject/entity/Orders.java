package com.edu.ismt.databaseproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Min(value = 1, message = "Table Id should not be 0 or negative")
    private int tableId;
    @NotBlank(message = "REQUIRED")
    private String orderDate;
    private Date deliveryDate;
    private String orderStatus;
    private String comments;

    public Orders() {
    }

    public Orders(int tableId, String orderDate, Date deliveryDate, String orderStatus, String comments) {
        this.tableId = tableId;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
