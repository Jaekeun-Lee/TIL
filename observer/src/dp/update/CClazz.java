package dp.update;

public class CClazz implements IObserver{

    private String name;

    public CClazz(String name) {
        this.name = name;
    }
    
    @Override
    public void update() {
        System.out.println(this.name + " 업데이트");
    }
}
