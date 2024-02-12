package com.assignment.backend.app.service;

import com.assignment.backend.app.dao.OrderDao;
import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Inventory;
import com.assignment.backend.app.model.Order;
import com.assignment.backend.app.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
@Component
public class OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    InventoryService inventoryService;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public List<Order> getOrdersByOrderType(OrderType orderType) {
        return orderDao.getOrdersByOrderType(orderType);
    }

    public Order getOrderByOrderId(String orderId) {
        return orderDao.getOrderByOrderId(orderId);
    }

    public Order createOrder(Order order) {
        if(order.getOrderType()==OrderType.PURCHASE_ORDER){
            for(OrderItem item:order.getItems()){
                Inventory inventory=new Inventory(item.getProductId(),item.getQuantity());
                inventoryService.addStock(inventory);
            }
            return orderDao.createOrder(order);
        }
        else{
            boolean doCreateOrder=true;
            List<OrderItem> items = order.getItems();
            for(OrderItem item:items){
                if(!inventoryService.isStockAvailable(item.getProductId(),item.getQuantity())){
                    doCreateOrder=false;
                    break;
                }
            }
            if(doCreateOrder) {
                for(OrderItem item:order.getItems()){
                    Inventory inventory=new Inventory(item.getProductId(),item.getQuantity());
                    inventoryService.sellStock(inventory);
                }
                return orderDao.createOrder(order);
            }
            else System.out.println("Stock not available, order not created");
        }
        return null;
        }

}
