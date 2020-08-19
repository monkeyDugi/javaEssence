package interfaceTest;

// 인스턴스를 직접 생성하지 않고 사용하기
// 다른 인스턴스로 바꿀 시 개발자가 하지 않아도 되므로 유연하다.
public class GetInstance {

    public static void main(String[] args) {
        AA a = new AA();
        a.methodA();
    }
}

class AA {
    void methodA() {
        II i = InstanceManager.getInstance();
        i.methodBB();
        System.out.println(i); // i로 Object 클래스의 메서드 호출가능
    }
}

interface II {
    public abstract void methodBB();
}

class BB implements II {
    public void methodBB() {
        System.out.println("methodB in B class");
    }

    public String toString() { return "class B"; }
}

// 인스턴스 변경 시  여기만 바꿔 주면 됨
class InstanceManager {

    public static II getInstance() {
        return new BB();
    }
}