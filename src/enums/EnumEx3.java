package enums;

/**
 * 열거형읯 추상 메서드 선언
 * - fare()를 모두 똑같이 구현 했지만, 다르게 구현될 수도 있게 하려고 추상 메서드로 선언하는 예시를 보여준다.
 * - 열거형에서 추상 메서드 사용은 거의 없다.
 */
enum Transportation {

    BUS(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    TRAIN(150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    SHIP(100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    },
    AIRPLANE(300) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };

    protected final int BASIC_FARE; // protected로 해야 각 상수에 접근 가능

    // private Taransportation(int baiscFare) {}
    Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }

    // 거리에 따른 요금 계산
    abstract int fare(int distance);
}
public class EnumEx3 {

    public static void main(String[] args) {
        System.out.println("bus fare = " + Transportation.BUS.fare(100));
        System.out.println("train fare = " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
    }
}
