import dp.button.Button;
import dp.button.IButtonListener;
import dp.update.*;

public class Main {

    public static void main(String[] args) {

        /*
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메세지 전달 : click1");
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4");
        */

        ISubject subject = new ConcreteSubject();

        AClazz a = new AClazz("A 구독자");
        BClazz b = new BClazz("B 구독자");
        CClazz c = new CClazz("C 구독자");

        subject.registerObserver(a);
        subject.registerObserver(b);
        subject.registerObserver(c);

        System.out.println("1차 업데이트");
        subject.notifyObserver(); // a, b, c 구독자 업데이트
        System.out.println("--------------------");

        System.out.println("C 구독자 제거");
        subject.removeObserver(c); // c 구독자 제거
        System.out.println("--------------------");

        System.out.println("2차 업데이트");
        subject.notifyObserver(); // a, b 구독자 업데이트
        System.out.println("--------------------");
    }
}
