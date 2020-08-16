package polymorphism.castingTestAndInstanceofTest;

public class CastingTest2 {

    public static void main(String[] args) {
        // 컴파일은 성공, 하지만 실행 시 에러 케이스
        // 기본적으로 다형성의 특징만 살펴보면 아래와 같이 자손타입은 조상 인스턴스(객체)를 참조할 수 없다.
        // 조상은 자손보다 멤버가 적거나 같기 때문에 자손에서 있는 멤버를 조상이 가지고 있지 않으면 자손이 사용할 수 없기 때문이다.
        // 즉 참조변수 형변환에서는 조상, 자손관계에서는 형변환이 가능하기 때문에 강제로 형변환을 시켜 컴파일은 통과하지만 실행 시 에러가 발생하게 되는 것 이다.
        //
        // Car car = new Car();  OK
        // Car car = new FireEngine(); : OK
        // FireEngine fe = new Car(); : ERROR

        Car car1 = new Car();
        Car car2 = null;
        FireEngine fe1 = null;

        car1.drive();
        // 컴파일은 성공, 실행 시 에러가 발생한다.
        // java.lang.ClassCastException: Car cannot be cast to FireEngine
        fe1 = (FireEngine) car1;
        fe1.drive();
        car2 = fe1;
        car2.drive();
    }
}
