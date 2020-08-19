package interfaceTest;

// 인터페이스의 장점
public class RepairableTest {
    public static void main(String[] args) {
       Tank tank = new Tank();
       Dropship dropship = new Dropship();
       Marine marine = new Marine();
       SCV scv = new SCV();

       // Repairable 인터페이스를 구현 받은 놈만 가능, 인터페이스 타입, 마린은 구현받지 않았으므로 수리 불
       scv.repair(tank);
       scv.repair(dropship);
//       scv.repair(marine); // 에러
    }


}

/*
 * 올바른 예
 */
interface Repairable { }

class GroundUnit extends Unit1 {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit1 {
    AirUnit(int hp) {
        super(hp);
    }
}

class Unit1 {
    int hitPoint;
    final int MAX_HP;

    Unit1(int hp) {
        MAX_HP = hp;
    }

    // ......
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150); // Tank의 HP는 150
        hitPoint = MAX_HP; // HP 감소
    }

    @Override
    public String toString() {
        return "Tank";
    }
}

class Dropship extends AirUnit implements Repairable {
    Dropship() {
        super(125); // Dropship의 HP는 125
        hitPoint = MAX_HP; // HP 감소
    }

    @Override
    public String toString() {
        return "Dropship";
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(40);
        hitPoint = MAX_HP; // HP 감소
    }
}

class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP; // HP 감소
    }

    void repair(Repairable repairable) {
        if (repairable instanceof Unit1) {
            Unit1 unit = (Unit1) repairable;

            while (unit.hitPoint != unit.MAX_HP) {
                // Unit 의 HP를 증가 시킨다.
                unit.hitPoint++;
            }

            System.out.println(unit.toString() + "의 수리 완료");
        }
    }
}

/* 안좋은 사례1
* SCV가 수리하기 기능이 있다면, 아래와 같이 기계별로 메서드를 만들어야 한다.
*  */
//void repair(Tank tank) {
//    // Tank 수리
//}
//void repair(Dropship dropship) {
//    // Dropship 수리
//}
/* 안좋은 사례2
 * 조상 클래스로 공통으로 묶는다고 해도 지장, 공중 유닛으로 나누어져 있다면 다를 바 없다.
 * 마린과 같은 지상유닛도 포함되기 때문에 올바르지 않다.
 *  */
//void repair(GroundUnit groupUnit) {
//    // 매개변수로 넘겨진 지상유닛(GroundUnit) 수리
//}
//void repair(AirUnit airUnit) {
//    // 매개변수로 넘겨진 공중유닛(AirUnit) 수리
//}