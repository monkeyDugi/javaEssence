package abstracttt.abstractClassAndAbstractMethod;

// 추상 클래스 사용법에 대해서 알아보기
public class AbstractMake1 {

    public static void main(String[] args) {
        // 추상화 전
//        Marine marine = new Marine();
        // 추상화 하지 않고 바로 구현으로 사용하면 Maring, Tank, DropShip 모두 각각
        // move와 stop을 만들어주어야 하고, 까먹게 될 경우가 발생할 수 있다는 단점이 있다.
//        marine.move(1, 2);
//        marine.stop();

        // 추상화 후
        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[2] = new DropShip();

        for (int i = 0; i < group.length; i++) {
            // 모든 유닛의 자표를 100, 200으로 설정
            group[i].move(100, 200);
            group[i].stop();
        }
    }
}

// 추상화 클래스로 공통기능 추출
// 모든 유닛은 이동해야하는 좌표가 다르기 때문에 추상화
// 멈추는 것은 모두 같으므로 구체화
abstract class Unit {
    int x, y;

    abstract void move(int x, int y); // 필수 기능으로 추상 메서드 구현
    void stop() { System.out.println("stop"); } // 추상 메서드는 아니지만 공통 기능이므로 추상 클래스에 구현
}

// 중복 코드 발생으로 추상 클래스로 공통으로 뺄 수 있다.
// int x, y
// move()
// stop()
//class Marine { // 추상화 전
    class Marine extends Unit { // 추상화 후

    // 추상화 전
    //
//    int x, y; // 현재위치
//    void move(int x, int y) { System.out.println("Marine move"); }
//    void stop () { System.out.println("stop"); }

    // 추상화 후
    // 추상화를 여 반드시 구현하도록
    @Override
    void move(int x, int y) { System.out.println("Marine move"); }

    void steamPack() { System.out.println("Marine steamPack"); }
}

//class Tank {
    class Tank extends Unit {

//    int x, y; // 현재위치
//    void move(int x, int y) { System.out.println("Tank move"); }
//    void stop () { System.out.println("stop"); }

    // 추상화 후
    @Override
    void move(int x, int y) { System.out.println("Tank move"); }

    void chaneMode() { System.out.println("Tank changeMode"); }
}

//class DropShip {
    class DropShip extends Unit {

//    int x, y; // 현재위치
//    void move(int x, int y) { System.out.println("DropShip move"); }
//    void stop () { System.out.println("stop"); }

    // 추상화 후
    @Override
    void move(int x, int y) { System.out.println("DropShip move"); }

    void load() { System.out.println("DropShip load"); }
    void unload() { System.out.println("DropShip unload"); }
}


