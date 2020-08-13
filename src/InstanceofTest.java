/**
 * 참조변수 형변환의 핵심 : 참조하는 인스턴스(객체)가 무엇인가
 * instanceof : 참조변수가 참조하고 있는 인스턴스(객체)를 확인하여, 형변환 하여도 되는지 확인하기 위해 사용한다.
 * fe는 FireEngine 인스턴스(객체)를 참조하고 있다.
 * 모든 케이스를 통과하게 되는데 FireEngine은 Car, Object의 자손이기 때문에 형변환을 해도 문제가 없기 때문이다.
 */
public class InstanceofTest {

    public static void main(String[] args) {
        FireEngine fe = new FireEngine();

        if(fe instanceof FireEngine) {
            System.out.println("This is a FireEngine instance");
        }

        if (fe instanceof Car) {
            System.out.println("This is a Car instance");
        }
//      조상 <-> 자손이 아니기 때문에 converting 에러
//        if(fe instanceof Ambulance) {
//            System.out.println("This is a Ambulance instance");
//        }

        if(fe instanceof Object) {
            System.out.println("This is a Object instance");
        }


        // 클래스명 출력
        System.out.println(fe.getClass().getName());
    }
}
