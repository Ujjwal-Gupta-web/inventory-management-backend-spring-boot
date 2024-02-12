package com.assignment.backend.app;

import com.assignment.backend.app.enums.Category;
import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Order;
import com.assignment.backend.app.model.OrderItem;
import com.assignment.backend.app.model.Product;
import com.assignment.backend.app.service.InventoryService;
import com.assignment.backend.app.service.OrderService;
import com.assignment.backend.app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
* 1 create two products milk,salt
* 2 create PURCHASE_ORDER 10,100 qty
* 3 verify current inventory 10,100
* 4 SALE_ORDER 3 qty milk
* 5 verify current inventory 7,100
* 6 SALE_ORDER 160 salt - fail
* 7 SALE_ORDER 50 salt 5 milk
* 8 verify current inventory 2,50
* 9 fetch all orders  - 3
* 10 increase milk price
* 11 SALE_ORDER 5 qty milk
* 12 verify current inventory 0,50
* 13 fetch all orders  - 4
* */

@SpringBootTest
public class GivenTests {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    InventoryService inventoryService;

    @Test
    public void test1(){

//        //TEST-1
//        List<Product> productsToAdd=new ArrayList<>();
//        productsToAdd.add(new Product(null,"MilkTest", Category.DAIRY,25));
//        productsToAdd.add(new Product(null,"SaltTest", Category.STAPLES,30));
//        List<Product> products=productService.addProducts(productsToAdd);
//
//        List<String> prodIds=new ArrayList<>();
//        for(Product product:products){
//            if(product.getName().equals("MilkTest")) prodIds.add(product.getProductId());
//            if(product.getName().equals("SaltTest")) prodIds.add(product.getProductId());
//        }
//        assertEquals(2,products.size());
//
//        //TEST-2
//        Order purchase_order_1=new Order(null, OrderType.PURCHASE_ORDER,new ArrayList<>(),new Date());
//        List<OrderItem> purchase_order_1_list=new ArrayList<>();
//        purchase_order_1_list.add(new OrderItem(prodIds.get(0),20,10));
//        purchase_order_1_list.add(new OrderItem(prodIds.get(1),25,100));
//
//        purchase_order_1.setItems(purchase_order_1_list);
//        assertNotEquals(null,orderService.createOrder(purchase_order_1));
//
//        //TEST-3
//        assertEquals(10,inventoryService.getInventoryByProductId(prodIds.get(0)).getQuantity());
//        assertEquals(100,inventoryService.getInventoryByProductId(prodIds.get(1)).getQuantity());
//
//        //TEST-4
//        Order sale_order_1=new Order(null, OrderType.SALE_ORDER,new ArrayList<>(),new Date());
//        List<OrderItem> sale_order_1_list=new ArrayList<>();
//        sale_order_1_list.add(new OrderItem(prodIds.get(0),25,3));
//        sale_order_1.setItems(sale_order_1_list);
//        assertNotEquals(null,orderService.createOrder(sale_order_1));
//
//        //TEST-5
//        assertEquals(7,inventoryService.getInventoryByProductId(prodIds.get(0)).getQuantity());
//        assertEquals(100,inventoryService.getInventoryByProductId(prodIds.get(1)).getQuantity());
//
//        //TEST-6
//        Order sale_order_2=new Order(null, OrderType.SALE_ORDER,new ArrayList<>(),new Date());
//        List<OrderItem> sale_order_2_list=new ArrayList<>();
//        sale_order_2_list.add(new OrderItem(prodIds.get(1),30,160));
//        sale_order_2.setItems(sale_order_2_list);
//        assertEquals(null,orderService.createOrder(sale_order_2));
//
//        //TEST-7
//        Order sale_order_3=new Order(null, OrderType.SALE_ORDER,new ArrayList<>(),new Date());
//        List<OrderItem> sale_order_3_list=new ArrayList<>();
//        sale_order_3_list.add(new OrderItem(prodIds.get(0),25,5));
//        sale_order_3_list.add(new OrderItem(prodIds.get(1),30,50));
//        sale_order_3.setItems(sale_order_3_list);
//        assertNotEquals(null,orderService.createOrder(sale_order_3));
//
//        //TEST-8
//        assertEquals(2,inventoryService.getInventoryByProductId(prodIds.get(0)).getQuantity());
//        assertEquals(50,inventoryService.getInventoryByProductId(prodIds.get(1)).getQuantity());
//
//        //TEST-9
//        assertTrue(orderService.getAllOrders().size()==3);
//
//        //TEST-10
//        productService.updateProductPriceByProductId(prodIds.get(0),28);
//        assertEquals(28,productService.getProductByProductId(prodIds.get(0)).getPrice());
//
//        //TEST-11
//        Order sale_order_4=new Order(null, OrderType.SALE_ORDER,new ArrayList<>(),new Date());
//        List<OrderItem> sale_order_4_list=new ArrayList<>();
//        sale_order_4_list.add(new OrderItem(prodIds.get(0),28,5));
//        sale_order_4.setItems(sale_order_3_list);
//        assertNotEquals(null,orderService.createOrder(sale_order_4));
//
//        //TEST-12
//        assertEquals(0,inventoryService.getInventoryByProductId(prodIds.get(0)).getQuantity());
//        assertEquals(50,inventoryService.getInventoryByProductId(prodIds.get(1)).getQuantity());
//
//        //TEST-13
//        assertTrue(orderService.getAllOrders().size()==4);

    }

}
