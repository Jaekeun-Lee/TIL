package dp.example.coffee;

public class Americano extends Beverage{

    public Americano() {
        name = "아메리카노";
    }

    @Override
    public int cost() {
        return 4000;
    }
}
