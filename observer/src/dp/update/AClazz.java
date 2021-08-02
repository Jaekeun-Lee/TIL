package dp.update;

public class AClazz implements IObserver {

    private String name;

    public AClazz(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.name + " 업데이트");
    }
}
