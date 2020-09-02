package generics;

import java.util.ArrayList;

class Fruit               { public String toString() { return "Fruit"; }}
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}
class Toy                 { public String toString() { return "Toy";   }}

public class FruitBoxEx1 {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<Apple>();
        Box<Toy> toyBox = new Box<>();
//        Box<Grape> grapeBox = new Box<Apple>(); // 에러. 타입 불일치

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple()); // 자손이기 때문에 OK.

        appleBox.add(new Apple());
        appleBox.add(new Apple());
//        appleBox.add(new Toy()); // 에러. Box<Apple>에는 Apple만 담을 수 있기 때문

        toyBox.add(new Toy());
//        toyBox.add(new Apple()); // 에러. Box<Toy>에는 Toy만 담을 수 있기 때문

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}

class Box<T> {

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
