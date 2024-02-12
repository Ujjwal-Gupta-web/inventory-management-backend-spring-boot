package com.assignment.backend.app.model;

import com.assignment.backend.app.enums.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "order")
public class Order {
    @Id
    private String orderId;
    private OrderType orderType;
    private List<OrderItem> items;
    @CreatedDate
    @JsonIgnore
    private Date timestamp;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderType=" + orderType +
                ", items=" + items +
                ", timestamp=" + timestamp +
                '}';
    }

    public Order(String orderId, OrderType orderType, List<OrderItem> items, Date timestamp) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.items = items;
        this.timestamp = timestamp==null?new Date():timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }




}
