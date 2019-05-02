package com.example.demo.OrderNumber;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: cj
 * @description 第二题：生成订单号
 * @date: 2019/4/29 17:50
 **/
@Getter
@Setter
public class OrderNumber {

    private final List<Long> lastOrderNumber = new LinkedList<>();

    public Long putOrderNumber(){
        Integer firstNumber = null;
        Long orderLongNumber = null;
        Long lastNumber = null;
        try {
            lastNumber = ((LinkedList<Long>) lastOrderNumber).getFirst();
        } catch (Exception e) {

        }
        //第一次常量集合无参数
        if(lastNumber == null){
            firstNumber = 0;
            String newTime = Long.toString(new Date().getTime());
            //截取时间戳后6位
            String index = newTime.substring(7);
            //订单编号自增
            String next = getIntToString(firstNumber);
            String orderStringNumber = index + next;
            orderLongNumber = getStringToLong(orderStringNumber);
            //添加到常量集合
            lastOrderNumber.add(orderLongNumber);
        }else {
            //常量集合有参数
            firstNumber = getNextNumber(lastNumber) + 1;

            //如果订单编号自增部分位数大于9，则重新归为0
            if(firstNumber.toString().length() >9){
                firstNumber = 0;
            }
            String newTime = Long.toString(new Date().getTime());
            //截取时间戳后6位
            String index = newTime.substring(7);
            //订单编号自增部分
            String next = getIntToString(firstNumber);
            String orderStringNumber = index + next;
            orderLongNumber = getStringToLong(orderStringNumber);
            //添加常量集合
            ((LinkedList<Long>) lastOrderNumber).removeFirst();
            lastOrderNumber.add(orderLongNumber);
        }
        return orderLongNumber;
    }

    /**
     * String转化int
     * @param number
     * @return
     */
    private int getStringToInt(String number){
        int nextNumber = 0;
        try {
            nextNumber = Integer.valueOf(number);
        } catch (NumberFormatException e) {

        }
        return nextNumber;
    }

    /**
     * int转化为String
     * @param number
     * @return
     */
    private String getIntToString(int number){
        String nextNumber = null;
        try {
            nextNumber = number+"";
        } catch (Exception e) {

        }
        return nextNumber;
    }

    /**
     * Long转化为String
     * @param number
     * @return
     */
    private String getLongToString(Long number){
        String nextNumber = null;
        try {
            nextNumber = number.toString();
        } catch (Exception e) {

        }
        return nextNumber;
    }

    /**
     * String转化Long
     * @param number
     * @return
     */
    private Long getStringToLong(String number){
        Long nextnumber = null;
        try {
            nextnumber = Long.valueOf(number);
        } catch (NumberFormatException e) {

        }
        return nextnumber;
    }
    //从上次订单中获得6位后的数字
    private int getNextNumber(Long orderNumber){
        String number = getLongToString(orderNumber);
        String nextStringNumber = number.substring(6);
        int nextIntNumber = getStringToInt(nextStringNumber);
        return nextIntNumber;
    }
}
