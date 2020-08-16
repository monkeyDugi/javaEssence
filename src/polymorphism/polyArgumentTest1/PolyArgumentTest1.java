package polymorphism.polyArgumentTest1;

// 매개변수의 다형성을 이용하여, 메서드를 간단하게 만들 수 있다.
public class PolyArgumentTest1 {

    public static void main(String[] args) {
        Buyer b = new Buyer();

        // 다형성은 조상타입 = 자손타입이 가능하고
        //        자손타입 = 조상타입이 불가능하기 때문에 반드시 조상타입을 매개변수로 지정해야 한다.
        // 조상타입으로 받는경우 형변환 생략이 되지만, 자손 타입으로 받는 경우는 형변환 생략이 되지 않기 때문에 매개변수 다형성으로는
        // 사용할 수 없는 것 이다.
        b.buy(new Tv()); // Tv 구입
        b.buy(new Computer()); // Computer 구입

        System.out.println("현재 남은 돈은 " + b.money + "만원 입니다.");
        System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점 입니다.");
    }
}

class Product {
    int price;       // 제품가격
    int bonusPoint;  // 제품구매 시 제공하는 보너스 점수

    public Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0); // 보너스 점수는 제품가격의 10%
    }
}

class Tv extends Product {

    Tv() {
        // 조상 클래스인 Product 생성자인 Product(int price)를 호출한다.
        super(1000000); // Tv의 가격은 1,000,000원
    }

    // 모든 클래스의 조상인 Object 클래스의 toString을 오버라이딩 한다.
    public String toString() {
        return "Tv";
    }
}

class Computer extends Product {

    Computer() {
        super(2000000);
    }

    public String toString() {
        return "Computer";
    }
}

// 물건을 사는 사람
class Buyer {
    int money = 10000000; // 고객의 소유 금액
    int bonusPoint = 0;   // 고객이 적립한 보너스 금액

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");

            return;
        }

        money -= p.price; // 고객의 소유 금액에서 구입한 제품가격을 뺀다.
        bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 고객의 보너스 점수에 추가한다.

        System.out.println(p + "을/를 구입하셨습니다.");
    }

    // 만약 매개변수의 다형성을 사용하지 않으면 아래 와 같이 오버로드를 사용해야 한다.
    // 제품이 추가 될 때 마다 메서드도 추가 되기 때문에 단점이다.
    // 즉 사용하지 않는 것이 좋다.
//    void buy(Tv t) {}
//    void buy(Computer c) {}
}