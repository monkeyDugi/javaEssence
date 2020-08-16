package castingTestAndInstanceofTest;

public class CastingTest1 {

    public static void main(String[] args) {
        /* Car 타입의 참조변수 car를  선언하고 null로 초기화 */
        Car car = null;
        /* FireEngine 인스턴스(객체)를 생성하고, FireEngine 타입의 참조변수가 참조하도록 한다. */
        FireEngine fe1 = new FireEngine();
        FireEngine fe2 = null;

        fe1.water();

        /*
        * fe1이 참조하고 있는 FireEngine 인스턴스(객체)를 참조변수 car가 참조
        * car는 FireEngine 인스턴스(객체)를 사용할 수 있지만 Car클래스의 멤버가 아닌 water()는 사용 불가
        *  */
        car = fe1; // 조상타입 <- 자손타입 (조상타입에 형변환이 되기 때문에 형변환 생략(FireEngine))
//        car.water(); // 에러 : car에는 water()가 없다
        // 조상을 자손으로 형변환 하는 것은 위험한 행위이다.
        // 조상은 자손보다 멤버가 적거나 같기 때문에 자손에서 있는 멤버를 조상이 가지고 있지 않으면 자손이 사용할 수 없기 때문이다.
        fe2 = (FireEngine) car; // 자손타입 <- 조상타입
        fe2.water(); // water()가 있으니 사용가능

        /*
        * 즉, car, fe1, fe2는 모두 같은 주소를 참조한다.
        * */
    }

}
