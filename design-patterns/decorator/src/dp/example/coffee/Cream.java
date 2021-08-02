package dp.example.coffee;

public class Cream extends CondimentDecorator {

    Beverage beverage;

    public Cream(Beverage beverage) {
        super();
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 500;
    }


    @Override
    public String getName() {
        return this.beverage.name + " +휘핑크림 추가";
    }
}
