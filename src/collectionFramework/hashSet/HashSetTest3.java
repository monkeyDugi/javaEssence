package collectionFramework.hashSet;


import java.util.HashSet;
import java.util.Objects;

public class HashSetTest3 {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        
        set.add("acb");
        set.add(new String("acb"));
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);

        /////////////////////////
        /**
         *  hashCode()의 필수조건
         *  1. 실행 중인 애플리케이션 내의 동일한 객체에 대해서 여러번 hashCode()를 호출해도 동일한 int 값을 반환해야 한다.
         *     하지만, 실행 시마다 동일한 int 값을 반환할 필요는 없다. (단, equlas메서ㅇ드의 구현에 사용된 멤버변수의 값이 바뀌지 않았다고 가정한다.)
         *     String 클래스는 문자열의 내용으로 해시코드를 만들어 내기 때문에 내용이 같은 문자열에 대한 hashCode()호출은 항상 동일한
         *     해시코드를 반환한다. 반면에 Object 클래스는 객체의 주소로 해시코드를 만ㄷ르어 내기 때문에 실행 할 때마다 해시코드 값이 달라질 수 있다.
         */
        Person2 p = new Person2("BD", 92);
        int hashCode1 = p.hashCode();
        System.out.println(hashCode1);
        int hashCode2 = p.hashCode();
        System.out.println(hashCode2);
        p.age = 20;
        int hashCode3 = p.hashCode();
        System.out.println(hashCode3);
        /**
         * 2. equals메서드를 이용한 비교에 의해서 true를 얻은 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 반드시 같아야 한다.
         */
        Person2 p1 = new Person2("David", 10);
        Person2 p2 = new Person2("David", 10);
        boolean b = p1.equals(p2);
        int hashCode4 = p1.hashCode();
        int hashCode5 = p2.hashCode();
        System.out.println(b);
        System.out.println(hashCode4);
        System.out.println(hashCode5);
        /**
         * 3. equals메서드를 호출했을 때 false를 반환하는 두 객체는 hashCoe() 호출에 대해 같은 int값을 반환하는 경우가 있어도 괜찮지만
         * 해싱(hashing)을 사용하는 컬렉션의 성능을 향상시키기 위해서는 다른 int값을 반환하는 것이 좋다.
         */
        /**
         * Tip
         * 두 객체애 대해 equals 메서드를 호출한 결과가 true이면, 두 객체의 해시코드는 반드시 같아야 하지만, 두 객체의 해시코드가 같아고 해서
         * equals메서드의 호출결가가 반드시 true이어야 하는 것은 아니다.
         * 사용자 정의 클래스를 작성할 때 equals메서드를 오버라이딩해야 한다면 hashCode()도 클래스의 작성의도에 맞게 오버라이딩하는 것이 원칙이지만,
         * 경우에 따라 위의 예제에서와 같이 간단히 구현하거나 생략해도 별 문제가 되지 않으므로 hashCode() 구현하는데 너무 부담 갖을 필요는 없다.
         */
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // add메서에에서 동일한 값인지 판별하기 위해 equlas를 만들어 주었다.
    public boolean equals(Object object) {
        if (object instanceof Person2) {
            Person2 tmp = (Person2) object;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

    // name이 String이기 때문에 String 클래스에 있는 hashCdoe메서드를 그대로 사용하여 hashCode도 만들어 주었따.
    public int hashCode() {
//        return (name + age).hashCode();
        // JDK1.8부터 아래와 같이 hashCode 작성이 가능하다.
        return Objects.hash(name, age);
    }

    public String toString() {
        return name + " : " + age;
    }
}