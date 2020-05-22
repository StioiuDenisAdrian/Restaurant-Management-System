package bll;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderID;
    private Date date;
    private int table;

    public Order() {

    }



    public Order(int orderId, Date date, int table) {
        this.orderID = orderId;
        this.date = date;
        this.table = table;
    }


    public int generateOrderID() {
        return date.getSeconds() * date.getHours() + date.getMinutes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return (orderID==order.orderID) && (table==order.table) && (date.equals(order.date));
    }

    @Override
    public int hashCode() {
        return orderID * 10 + table;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Date getDate() {
        return date;
    }




}
