package bll;

import bll.IRestaurantProcessing;
import bll.Order;
import dao.FileWriter;
import java.awt.MenuItem;
import java.io.Serializable;
import java.util.*;
import java.util.List;

/**
 * Restauratn class holds a list of menu items, and contains a map of the orders.
 * It implements the methods from the IRestaurantProcessing interface, and implements serialisable in order to be sserialised
 */

public class Restaurant extends Observable implements IRestaurantProcessing, Serializable {

    private Map<Order, Collection<MenuItem>> orderHistory = new HashMap<>();
    private ArrayList<MenuItem> menuContent;

    /**
     * Invariant of an object, to make sure it is not null
     * @param o object to be tested
     */
    private static void notNull(Object o) {
        assert o != null;
    }

    /**
     * Constructor of the class
     */
    public Restaurant(){
        this.orderHistory=new LinkedHashMap<>();
        this.menuContent=new ArrayList<>();
        if(!invariant()){
            throw new ExceptionInInitializerError();
        }
    }

    /**
     * Class invariant
     * @return true if the conditions are met, and false otherwise
     */
    private boolean invariant(){
        if(menuContent==null || orderHistory==null)
            return false;
        return true;
    }


    /**
     * Add a new item to the menu
     * @param item the item to be added
     */
    @Override
    public void createMenuItem(MenuItem item) {
        notNull(item);
        int originalSize=menuContent.size();
        menuContent.add(item);
        assert menuContent.size()==originalSize+1;
    }

    /**
     * Deletes an item with a specified inedx
     * @param index
     */
    @Override
    public void deleteMenuItem(int index) {
        assert index>=0;
        assert index<menuContent.size();
        int originalSize=menuContent.size();
        menuContent.remove(index);
        assert menuContent.size()==originalSize-1;
    }

    /**
     * Edit an item from the menu
     * @param id
     * @param item
     */
    @Override
    public void editMenuItem(int id, MenuItem item) {
        notNull(item);
        assert (id>=0) && (id<menuContent.size());
        menuContent.set(id,item);
    }

    /**
     *Adds a new order
     * @param order to be added
     * @param item item commanded
     */
    @Override
    public void createNewOrder(Order order, ArrayList<MenuItem> item) {
        notNull(order);
        int originalSize=orderHistory.size();
        orderHistory.put(order,item);
        assert orderHistory.size()==originalSize+1;
        setChanged();
        notifyObservers();
    }

    /**
     * Computes the price of an order
     * @param order order to be computed
     * @return the price of the order
     */
    @Override
    public double computePrice(Order order) {
        notNull(order);
        double price=0;
        for(MenuItem mi: orderHistory.get(order))
            price+=mi.computePrice();
        return 0;
    }

    /**
     * Generates a bill for the order
     * @param order the selected order
     * @param id id of the order
     */
    @Override
    public void generateBill( Order order, int id) {
        FileWriter fw= new FileWriter();
        fw.bill(order,orderHistory.get(order),id);
    }

    /**
     * Getter for the orders
     * @return the orders
     */
    public Map<Order, Collection<MenuItem>> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Getter for the menu content
     * @return
     */
    public ArrayList<MenuItem> getMenuContent() {
        return menuContent;
    }

    /**
     * Find order after index
     * @param index to search
     * @return the found order
     */
    public Order getOrder(int index){
        List key = new ArrayList(orderHistory.keySet());
        return (Order) key.get(index);
    }

    /**
     * Finds the number of orders
     * @return
     */
    public int getNumberOfOrders(){
        return orderHistory.size();
    }

    /**
     * Get the content of the menu
     * @param order order to search
     * @return the menu content
     */
    public List<MenuItem> getMContent(Order order){
        return (List<MenuItem>) orderHistory.get(order);
    }

    /**
     * Get a menu item after its name
     * @param s the name of the menu item
     * @return the found item
     */
    public MenuItem getMenuItem(String s){
        MenuItem m=null;
        for(MenuItem mi : menuContent)
            if(mi.getName().equals(s))
                m=mi;
            return m;
    }

    /**
     * Find a menu item after index
     * @param index
     * @return
     */
    public MenuItem getMenuItem(int index){
        return menuContent.get(index);
    }

    /**
     * Get the number of products
     * @return number of products
     */
    public int getNumberProducts(){
        return menuContent.size();
    }

}
