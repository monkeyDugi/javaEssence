package bindingTest1;

// 조상타입의 참조변수, 자손타입의 참조변수에 중복된 멤버변수가 사용될 경우, 자기 타입의 멤버변수를 사용한다.
// 중복 메서드의 경우 자손에서 오버라이딩을 하기 때문에 오버라이딩 메서드가 사용된다.
public class BindingTest1 {

    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }

}

class Parent {

    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {

    int x = 200;

    void method() {
        System.out.println("Child Method");
    }
}