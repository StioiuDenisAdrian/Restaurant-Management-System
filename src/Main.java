import bll.Restaurant;
import dao.Serializator;
import presentation.Controller;
import presentation.View;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant =new Restaurant();

        Serializator serializator = new Serializator(restaurant);
        restaurant=serializator.deserialize("bll.Restaurant.ser");

        View view= new View(restaurant);
        Controller controller= new Controller(restaurant,view);

        view.setVisible(true);
    }
}
