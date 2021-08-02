package dp.update;

public interface ISubject {

    //등록
    void registerObserver(IObserver observer);

    //해제
    void removeObserver(IObserver observer);

    //갱신
    void notifyObserver();
}
