package dp.example.coffee;

public abstract class Beverage {

    /**
     * 가장 상위의 슈퍼클래스 Beverage
     * 음료의 공통적인 성질을 따로 뺸 것으로
     * 카페에서 판매하는 모든 음료는 이 클래스를 상속받아야 함.
     */

    String name = "no title"; // 음료이름

    public abstract int cost();

    public String getName() {
        return name;
    }
}
