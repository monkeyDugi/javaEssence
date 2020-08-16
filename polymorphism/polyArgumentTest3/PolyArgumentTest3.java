package polyArgumentTest3;

import java.util.Vector;

// 매개변수의 다형성을 이용하여, 메서드를 간단하게 만들 수 있다.(Vector사용)
// Vector는 단순히 동적으로 크가가 관리되는 객체 배열이다.
public class PolyArgumentTest3 {

    public static void main(String[] args) {
        Buyer b = new Buyer();

        Tv tv = new Tv();
        Computer computer = new Computer();
        Audio audio = new Audio();

        // 다형성은 조상타입 = 자손타입이 가능하고
        //        자손타입 = 조상타입이 불가능하기 때문에 반드시 조상타입을 매개변수로 지정해야 한다.
        // 조상타입으로 받는경우 형변환 생략이 되지만, 자손 타입으로 받는 경우는 형변환 생략이 되지 않기 때문에 매개변수 다형성으로는
        // 사용할 수 없는 것 이다.
        b.buy(tv); // Tv 구입
        b.buy(computer); // Computer 구입
        b.buy(audio); // Audio 구입
        b.summary();

        System.out.println();

        b.refund(computer);

        b.summary();

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

class Audio extends Product {

    Audio() {
        super(500000);
    }

    public String toString() {
        return "Audio";
    }
}

// 물건을 사는 사람
class Buyer {
    int money = 10000000; // 고객의 소유 금액
    int bonusPoint = 0;   // 고객이 적립한 보너스 금액
    Vector item = new Vector(); // 구입한 제품을 저장하는데 사용될 Vector 객체

    int i = 0; // Product 배열에 사용될 index

    void buy(Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");

            return;
        }

        money -= p.price; // 고객의 소유 금액에서 구입한 제품가격을 뺀다.
        bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 고객의 보너스 점수에 추가한다.

        item.add(p); // 구입한 제품을 장바구니에 저장

        System.out.println(p + "을/를 구입하셨습니다.");
    }

    // 구입한 제품 환불
    void refund(Product p) {
        if (item.remove(p)) { // 제품을 Vector에서 제거
            money += p.price;
            bonusPoint -= p.bonusPoint;

            System.out.println(p + "를/을 반품하셨습니다.");
        } else {
            System.out.println("구입하신 제품 중 " + p + " 제품이 없습니다.");
        }

    }

    // 구매한 제품의 정보를 요약하여 보여준다.
    void summary() {
        int sum = 0; // 구입한 물품의 합계
        String itemList = ""; // 구입한 물품의 목록

        // Vector가 비어있는지 확인
        if (item.isEmpty()) {
            System.out.println("구입하신 제품이 없습니다.");
            return;
        }

        // 구매 금액 합계와 구매 목록을 만든다.
        for (int i = 0; i < item.size(); i++) {
            Product p = (Product)item.get(i);

            sum += p.price;
            itemList += (i==0) ? "" + p : ", " + p;
        }

        System.out.println("구입하신 물품의 총 금액은 " + sum + "만원 입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}