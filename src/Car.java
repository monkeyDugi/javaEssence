/**
 * FireEngine과 Ambulance는 아무런 관계가 없다.
 */

public class Car {
    String color;
    int door;

    void drive() {
        System.out.println("운전 하기");
    }

    void stop() {
        System.out.println("정지");
    }
}

// 소방차
class FireEngine extends Car {

    void water() {
        System.out.println("물 뿌리기");
    }
}

// 구급차
class Ambulance extends Car {

    void siren() {
        System.out.println("삐뽀! 삐뽀!" + color);
    }
}
