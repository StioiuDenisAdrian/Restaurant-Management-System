package bll;

import java.util.List;

public class CompositeProduct extends MenuItem {
    private final List<MenuItem> items;

    public CompositeProduct(String name, List<MenuItem> items){
        super(name,0);
        this.items=items;
        setPrice(computePrice());
    }

    @Override
    public double computePrice(){
        double price=0;
        for(MenuItem mi: items)
            price+=mi.getPrice();
        return price;
    }


    @Override
    public String ingredients(){
        StringBuilder i =new StringBuilder();
        for(MenuItem mi: items)
            i.append(mi.ingredients()).append(", ");
        return String.valueOf(i);
    }
}
