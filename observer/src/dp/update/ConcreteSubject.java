package dp.update;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements ISubject {

    private List<IObserver> observers;

    public ConcreteSubject() {
        observers = new ArrayList<IObserver>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observers.indexOf(observer));
    }

    @Override
    public void notifyObserver() {
        observers.stream().forEach(observer -> {
            observer.update();
        });
    }


}

