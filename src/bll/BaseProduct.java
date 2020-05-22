package bll;

public class BaseProduct extends MenuItem {

    public BaseProduct(String name, double price) {
        super(name,price);
    }


  @Override
  public  double computePrice(){
        return price;
  }

  @Override
    public String ingredients(){
        return name;
  }

}
