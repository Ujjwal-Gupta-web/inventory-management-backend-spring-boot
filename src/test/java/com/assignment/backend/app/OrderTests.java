package com.assignment.backend.app;

import com.assignment.backend.app.dao.OrderDao;
import com.assignment.backend.app.enums.OrderType;
import com.assignment.backend.app.model.Order;
import com.assignment.backend.app.model.OrderItem;
import com.assignment.backend.app.service.InventoryService;
import com.assignment.backend.app.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderTests {

    @Mock
    private OrderDao orderDao;

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        // Mock data
        List<Order> mockOrders = Arrays.asList(
                new Order("1", OrderType.PURCHASE_ORDER, Arrays.asList(new OrderItem("1", 10.0, 5)), new Date()),
                new Order("2", OrderType.SALE_ORDER, Arrays.asList(new OrderItem("2", 20.0, 3)), new Date())
        );

        when(orderDao.getAllOrders()).thenReturn(mockOrders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetOrdersByOrderType() {
        // Mock data
        OrderType orderType = OrderType.SALE_ORDER;
        List<Order> mockOrders = Arrays.asList(
                new Order("2", OrderType.SALE_ORDER, Arrays.asList(new OrderItem("2", 20.0, 3)), new Date())
        );

        when(orderDao.getOrdersByOrderType(orderType)).thenReturn(mockOrders);

        List<Order> result = orderService.getOrdersByOrderType(orderType);

        assertEquals(1, result.size());
    }

    @Test
    public void testGetOrderByOrderId() {
        String orderId = "123";
        Order mockOrder = new Order(orderId, OrderType.PURCHASE_ORDER, Arrays.asList(new OrderItem("1", 10.0, 5)), new Date());

        when(orderDao.getOrderByOrderId(orderId)).thenReturn(mockOrder);

        Order result = orderService.getOrderByOrderId(orderId);

        assertEquals(orderId, result.getOrderId());
    }

    @Test
    public void testCreateOrder_PurchaseOrder() {
        Order order = new Order("123", OrderType.PURCHASE_ORDER, Arrays.asList(new OrderItem("1", 10.0, 5)), new Date());

        when(orderDao.createOrder(order)).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertEquals(order, result);
    }

    @Test
    public void testCreateOrder_SalesOrderWithSufficientStock() {
        OrderItem item = new OrderItem("1", 10.0, 5);
        Order order = new Order("123", OrderType.SALE_ORDER, Arrays.asList(item), new Date());

        when(inventoryService.isStockAvailable(item.getProductId(), item.getQuantity())).thenReturn(true);
        when(orderDao.createOrder(order)).thenReturn(order);

        Order result = orderService.createOrder(order);

        assertEquals(order, result);
    }

    @Test
    public void testCreateOrder_SalesOrderWithInsufficientStock() {
        OrderItem item = new OrderItem("1", 10.0, 5);
        Order order = new Order("123", OrderType.SALE_ORDER, Arrays.asList(item), new Date());

        when(inventoryService.isStockAvailable(item.getProductId(), item.getQuantity())).thenReturn(false);

        Order result = orderService.createOrder(order);

        assertEquals(null, result);
    }

}
