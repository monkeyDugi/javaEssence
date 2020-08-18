package interfaceTest;

import java.util.logging.Filter;

// 인터페이스와 클래스간의 관계 알아보기
public class FighterTest {

    public static void main(String[] args) {
        Fighter fighter = new Fighter();

        if (fighter instanceof Unit) {
            System.out.println("fighter는 Unit 클래스의 자손");
        }
        // 자손이라고 표현하기도 하지만 엄밀히 말 하면 인터페이스는 조상 자손 관계가 아닌 구현관계라고 표현한다.
        if (fighter instanceof Fightable) {
            System.out.println("fighter는 Fightable 인터페이스를 구현");
        }
        if (fighter instanceof Movable) {
            System.out.println("fighter는 Movable 인터페이스를 구현");
        }
        if (fighter instanceof Attackable) {
            System.out.println("fighter는 Attackable 인터페이스를 구현");
        }
        if (fighter instanceof Object) {
            System.out.println("fighter는 Object 클래스의 자손");
        }
    }
}

// 인터페이스 구현, 클래스 상속(다중상속)
// Fightable 인터페이스에 Movable, Attackable을 다중 상속을 받았기 때문에 사용하는 클래스에서
// 추상메서드를 implements(구현) 해주어야 함
class Fighter extends Unit implements Fightable {
    public void move(int x, int y) {
        // 생략
    }

    public void attack(Unit unit) {
        // 생략
    }
}

class Unit {
    int currentHP; // 체력
    int x;         // 위치
    int y;         // 위치
}

// Fightable 인터페이스에 Movable, Attackable을 다중 상속 받음
interface Fightable extends Movable, Attackable { }
interface Movable {
    public abstract void move(int x, int y);
}
interface Attackable {
    public abstract void attack(Unit unit);
}
