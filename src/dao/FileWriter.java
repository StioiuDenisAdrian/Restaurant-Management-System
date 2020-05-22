package dao;

import bll.Order;

import java.awt.MenuItem;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;


public class FileWriter {
    public static void bill(Order order, Collection<MenuItem> item, int id){
        StringBuilder bill = new StringBuilder();
        bill.append("BILL\n");
        bill.append("Order ID: ").append(order.getOrderID());
        bill.append("\nDate: ").append(order.getDate());
        bill.append("\nTable number: ").append(order.getTable());
        item.forEach(menuItem -> bill.append("\n").append(menuItem.getName()).append(" ").append(menuItem.computePrice()));
        double price = 0;
        for(MenuItem m : item)
            price += m.computePrice();
        bill.append("\nPrice: ").append(price);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bill" + id + ".txt"), StandardCharsets.UTF_8))) {
            writer.write(String.valueOf(bill));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
