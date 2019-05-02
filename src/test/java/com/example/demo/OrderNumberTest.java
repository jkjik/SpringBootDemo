package com.example.demo;

import com.example.demo.OrderNumber.OrderNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: cj
 * @description TODO
 * @date: 2019/5/1 14:16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderNumberTest {
    @Test
    public void test(){
        OrderNumber orderNumber = new OrderNumber();
        for(int i =0;i<10;i++){
            System.out.println("++++++++++++++++");
            System.out.println(orderNumber.putOrderNumber());
        }
    }
}
