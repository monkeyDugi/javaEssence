package interfaceTest;

public class ABandAIB {

    public static void main(String[] args) {
        // 안좋은 예
        // 클래스 C가 추가되면 클래스 A의 매개변수도 C로 변경 되어야 한다.
        // A클래스 사용을 위해서는 반드시 클래스 B가 만들어져 있어야 한다.
//        A a = new A();
//        a.methodB(new B());

        // 좋은 예
        // 매개변수가 바뀌어도 A 클래스는 변함 없음
        A a = new A();
        a.autoPlay(new B());
        a.autoPlay(new C());
    }
}

/*
 * 인터페이스의 이해를 위한 개념
 * 클래스를 사용하는 쪽과 제공하는 쪽이 있다.
 * 메서드를 사용하는 쪽에서는 사용하려는 메서드의 선언ㄹ부만 알면된다 ( 내용은 몰라도 된다 )
 */

/* 좋은 예 */
class A {
    void autoPlay(I i) {
        i.play();
    }
}
interface I {
    public abstract void play();
}
class B implements I {
    public void play() {
        System.out.println("play in B class");
    }
}
class C implements I {
    public void play() {
        System.out.println("play in C class");
    }
}


/* 안좋은 예 */
//class A {
//    public void methodB(B b) {
//        b.methodB();
//    }
//}
//
//class B {
//    public void methodB() {
//        System.out.println("methodB()");
//    }
//}
