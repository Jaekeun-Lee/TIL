package dp.update;

public class BClazz implements IObserver{

    private String name;

    public BClazz(String name) {
        this.name = name;
    }
    
    @Override
    public void update() {
        System.out.println(this.name + " 업데이트");
    }
}
