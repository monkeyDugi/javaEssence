package hashCodeAndEquals;

import java.util.Objects;

// Object 클래스인 hasCode(), equals()에 대해서 알아보자
// hasCode() : 객체의 주소를
public class hashCodeAndEquals {

    public static void main(String[] args) {
        /* hashCode 비교
        * 이미 String 클래스에 오버라이딩 되어 있기 때문에 값을 비교하고, hashCode도 같다.
        * */

//        String str1 = new String("ddd");
//        String str2 = new String("ddd");
//
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.hashCode());
//        System.out.println(str2.hashCode());



        /*
        * 사용자 정의 클래스에 오버라이딩 테스트
        * 서로 다른 객체는 다른 주소를 가진다.
        * */
        Card card1 = new Card();
        Card card2 = new Card();

        // equals()를 오버라이딩 하지 않으면 false, 오버라이딩 하면 true
        // 즉, 오버라이딩 하지 않으면 주소를 비교하는 것 이다.
        System.out.println(card1.equals(card2));

        // String타입인 kind는 이미 오버라이딩이 되어 있기 때문이다.
        // int 타입인 number는 객체가 아니기 때문에 사용불가는 당연!!
        System.out.println(card1.kind.equals(card2.kind));


        System.out.println(card1.hashCode());
        System.out.println(card2.hashCode());

        System.out.println(card1.toString());
        System.out.println(card2.toString());

    }
}

class Card {
    String kind;
    int number;

    Card() {
        this("SPACE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // equals()를 오버라이딩 했으면, 반드시 hashCode()도 오버라이딩 한다.
    @Override
    public int hashCode() {
        return Objects.hash(kind, number);
    }

    // 주소 비교가 아닌 값 비교를 위해 오버라이딩
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Card)) return false;
        Card card = (Card)object;

        return this.kind.equals(card.kind) && this.number == card.number;
    }

    @Override
    public String toString() {
        return "kind : " + this.kind + ", number : " + this.number;
    }
}



