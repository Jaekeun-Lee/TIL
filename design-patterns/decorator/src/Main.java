import dp.example.car.*;
import dp.example.coffee.Americano;
import dp.example.coffee.Beverage;
import dp.example.coffee.Shot;

public class Main {

    public static void main(String[] args) {

        // Example Car
        ICar audi = new Audi(1000);
        audi.showPrice();

        //a3
        ICar audiA3 = new A3(audi, "A3");
        audiA3.showPrice();

        //a4
        ICar audiA4 = new A4(audi, "A4");
        audiA4.showPrice();

        //a5
        ICar audiA5 = new A5(audi, "A5");
        audiA5.showPrice();


        // Example Coffee
        Beverage americano = new Americano();
        americano = new Shot(americano);
        americano = new Shot(americano);
        americano = new Shot(americano);

        System.out.println("메뉴 : " + americano.getName());
        System.out.println("가격 : " + americano.cost());

    }
}
