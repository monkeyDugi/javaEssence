package generics;

import java.util.ArrayList;

/**
 * extends로 상한 제한 ( T의 자손만 가능 )
 * static Juice makeJuice(FruitBox<? extends Fruit2> box) {
 */
class Fruit2 { public String toString() { return "Fruit"; }}
class Apple2 extends Fruit2 { public String toString() { return "Apple"; }}
class Grape2 extends Fruit2 { public String toString() { return "Grape"; }}

class Juice {

    String name;

    Juice(String name) { this.name = name + "Juice"; }
    public String toString() { return name; }
}
class Juicer {

    static Juice makeJuice(FruitBox<? extends Fruit2> box) {
        String tmp = "";

        for (Fruit2 f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
public class FruitBoxEx3 {

    public static void main(String[] args) {
        FruitBox<Fruit2> fruitBox = new FruitBox<Fruit2>();
        FruitBox<Apple2> appleBox = new FruitBox<Apple2>();

        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
        appleBox.add(new Apple2());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }
}

class FruitBox<T extends Fruit2> extends Box2<T> {}

class Box2<T> {

    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    ArrayList<T> getList() { return list; }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
}
