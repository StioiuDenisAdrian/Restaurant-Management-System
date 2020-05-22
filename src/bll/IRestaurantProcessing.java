package bll;

import bll.MenuItem;

import java.util.ArrayList;

public interface IRestaurantProcessing {
    void createMenuItem(MenuItem item);

    void deleteMenuItem(int index);

    void editMenuItem(int id, MenuItem item);

    void createNewOrder(Order order, ArrayList<MenuItem> item);

    double computePrice(Order order);

    void generateBill(Order order, int id);
}
