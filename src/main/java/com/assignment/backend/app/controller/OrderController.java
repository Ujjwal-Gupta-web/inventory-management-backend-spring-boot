package com.assignment.backend.app.controller;

import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Order;
import com.assignment.backend.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    /*
    getAllOrders
    getOrderByOrderId
    getOrdersByOrderType – [orderType]
    createOrder - {Order}
* */

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders(){
        try{
            List<Order> orders=orderService.getAllOrders();
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/type/{orderType}")
    public ResponseEntity<List<Order>> getOrdersByOrderType(@PathVariable OrderType orderType){
        try{
            List<Order> orders=orderService.getOrdersByOrderType(orderType);
            return ResponseEntity.status(HttpStatus.OK).body(orders);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId){
        try{
            Order order=orderService.getOrderByOrderId(orderId);
            if(order==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        try{
            Order newOrder=orderService.createOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
