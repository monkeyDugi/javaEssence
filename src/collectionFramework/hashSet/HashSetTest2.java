package collectionFramework.hashSet;

import java.util.HashSet;

/**
 * Person 객체의 name과 age가 같은면 같은 사람으로 취급하고
 * 다른 사람으로 취급하고 있는 코드이다.
 * 이를 위한 해결 방법은 HashsetTest3.java에서 확인하자
 */
public class HashSetTest2 {

    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("dugi",  29));
        set.add(new Person("dugi",  29));

        System.out.println(set);
    }
}

class Person {

    String name;
    int age;

    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " : " + age;
    }
}