package generics;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 제한된 지네릭 클래스
 *
 * 한 종류의 타입만 저장할 수 있도록 제한은 했지만, 그래도 여전히 모든 종류의 타입을 지정할 수있다는 것은 변함 없다.
 * 그래서 가능한 방법은??
 * extends를 이용한 자손만 되도록 제한하는 것 이다.
 * 인터페이스도 동일하게 extends로 제한 가능
 */

interface Eatable {}
class Fruit1 implements Eatable {
    public String test = "1";
    public String toString() {return "Fruit1"; }
}
class Apple1 extends Fruit1 { public String toString() { return "Apple1"; }}
class Grape1 extends Fruit1 { public String toString() { return "Grape1"; }}
class Toy1                 { public String toString() { return "Toy1"; }}
class Berry implements Eatable {
    public String toString() { return "berry"; }
}

public class FruitBoxEx2 {

    public static void main(String[] args) {

        FruitBox1<Fruit1> fruitBox1 = new FruitBox1<Fruit1>();
        FruitBox1<Apple1> appleBox1 = new FruitBox1<Apple1>();
        FruitBox1<Grape1> grapeBox1 = new FruitBox1<Grape1>();
    //    FruitBox1<Grape1> grapeBox1 = new FruitBox1<Apple>(); // 에러. 타입 불일치
    //    FruitBox1<Toy1> toyBox = new FruitBox1<Toy1>(); // 에러. Fruit1과 Eatable의 자손이 아니라서 불가
    //    FruitBox1<Berry> berry = new FruitBox1<Berry>(); // 에러. Eatable만 구현 받았고, Fruit1은 상복 받지 않음.

        fruitBox1.add(new Fruit1());
        fruitBox1.add(new Apple1());
        fruitBox1.add(new Grape1());
        appleBox1.add(new Apple1());
//        appleBox1.add(new Grape1()); // 에러. Apple의 자손이 아님
        grapeBox1.add(new Grape1());

        System.out.println("fruitBox1 : " + fruitBox1);
        System.out.println("appleBox1 : " + appleBox1);
        System.out.println("grapeBox1 : " + grapeBox1);
    }

}

// Fruit1과 Eatable의 자손만 가능
class FruitBox1<T extends Fruit1 & Eatable> extends Box<T> {}
class Box1<T> {

    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}
