package dp.example.coffee;

public class Shot extends CondimentDecorator {

    Beverage beverage;

    public Shot(Beverage beverage) {
        super();
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 300;
    }

    @Override
    public String getName() {
        return beverage.getName() + " +샷 추가";
    }
}
