package polymorphism.bindingTest2;

// 조상, 자손의 인스턴스 변수를 선택하여 사용하기 위해서 super(조상), this(자손)을 사용한다.
public class BindingTest2 {

    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println();

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
        System.out.println("x=" + x); // this.x와 같음
        System.out.println("super.x=" + super.x); // 조상의 인스턴스 변수 사용
        System.out.println("this.x=" + this.x); // 나 자신의 인스턴스 변수 사용
    }
}