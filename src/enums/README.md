# 열거형
- 열거형의 생성자는 기본이 private
- 열거형은 하나하나 가 모두 객체를 생성하는 것 이다.

## 열거형의 이해
 - 주석으로 1, 2, 3 코드별로 과일의 코드를 알려주고 있지만, 주석이 없어지거나, 주석을 잘못 달거나 할 경우 혼란을 줄 수 있다.
```java 
public class EnumTest1 {

    public static void main(String[] args) {
        /**
         * 1. 사과
         * 2. 복숭아
         * 3. 바나나
         */
        int type = 1;
        switch (type) {
            case 1: System.out.println("사과"); break;
            case 2: System.out.println("복숭아"); break;
            case 3: System.out.println("바나나"); break;
        }
    }
}
```

---

- EnumTest1에서는 주석이 없으면 알아 볼 수 없었지만, 상수로 관리하여, 알아보기 쉽게 변하였다.
```java
public class EnumTest2 {

    private final static int APPLE = 1;
    private final static int PEACH = 2;
    private final static int BANANA = 3;

    public static void main(String[] args) {
        int type = APPLE;
        switch (type) {
            case APPLE: System.out.println("사과"); break;
            case PEACH: System.out.println("복숭아"); break;
            case BANANA: System.out.println("바나나"); break;
        }
    }
}
```

---

 - EnumTest2에서 프로그램이 커지면서 기업에 대한 상수가 필요해졌다. 라는 상황이 왔을 때?? 어떻게 될까??
 - 아래와 같이 작성 하였다. 하지만 굉장히 지저분해 졌다. 어쩌지??
 ```java
public class EnumTest3 {

    // fruit
    private final static int FRUIT_APPLE = 1;
    private final static int FRUIT_PEACH = 2;
    private final static int FRUIT_BANANA = 3;

    // company
    // fruit의 APPLE과 중복되기 때문에 컴파일 에러가 발생하여 문제는 없지만,
    // 이미 다양한 영역에서 기업 APPLE을 사용 중이라면?? 낭패다.
    // 그래서 prefix를 붙여 관리한다.
//    private final static int GOOGLE = 1;
//    private final static int APPLE = 2;
//    private final static int ORACLE = 3;

    // prefix로 관리
    private final static int COMPANY_GOOGLE = 1;
    private final static int COMPANY_APPLE = 2;
    private final static int COMPANY_ORACLE = 3;

    public static void main(String[] args) {
        int type = FRUIT_APPLE;
        switch (type) {
            case FRUIT_APPLE: System.out.println("사과"); break;
            case FRUIT_PEACH: System.out.println("복숭아"); break;
            case FRUIT_BANANA: System.out.println("바나나"); break;
        }
    }
}
```

---

- EnumTest3에서 지저분한 것을 개선
- 인터페이스를 사용
- 깔끔해졌지만 문제는?
- FRUIT와 COMPANY의 코드 값이 같기 때문에 FRUIT.APPLE과 COMPABY.GOOGLE은 같다. 이게 문제이다.
```java
public class EnumTest4 {

    public static void main(String[] args) {
        int type = FRUIT.APPLE;
        switch (type) {
//            case FRUIT.APPLE: System.out.println("사과"); break;
            // 값이 같기 때문에 FRUIT의 APPLE을 비교하고 싶은데 COMPANY.GOOGLE과 같다고 나왔다. 문제
            case COMPANY.GOOGLE: System.out.println("사과"); break;
            case FRUIT.PEACH: System.out.println("복숭아"); break;
            case FRUIT.BANANA: System.out.println("바나나"); break;
        }
    }
}

// 인터페이스의 public final static을 이용하여 분리 하였다.
interface FRUIT {
    int APPLE = 1;
    int PEACH = 2;
    int BANANA = 3;
}
interface COMPANY {
    int GOOGLE = 1;
    int APPLE = 2;
    int ORACLE = 3;
}
```

---

- EnumTest4에서 FRUIT와 COMPANY의 코드 값이 같은 문제를 해결하기 위해 클래스로 만들어 객체를 생성하여, 다른 타입은 비교조차 불가능하게 컴파일 단계에서 막았다.
- 문제점
- switch문은 String만 사용할 수 있기 때문에 사용이 불가
- 선언이 너무 복잡하다. 계속 public static final = new 클래스(); 를 해주어야 한다.
```java
public class EnumTest5 {

    public static void main(String[] args) {
        // 애초에 다른 타입이기 때문에 비교 불가
        // Operator '==' cannot be applied to 'FRUIT1', 'COMPANY1'
//        if(Fruit.APPLE == Company.APPLE) {
//            System.out.println("과일 애플과 회사 애플이 같다.");
//        }
        Fruit type = Fruit.APPLE;
        if(Fruit.APPLE == type) {
            System.out.println("사과");
        }
    }
}

class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
}

class Company {
    public static final Company GOOGLE = new Company();
    public static final Company APPLE = new Company();
    public static final Company ORACLE = new Company();
}
```

---

- EnumTest4에서의 문제점을 해결하기 위해 enum 클래스를 사용
```java
public class EnumTest6 {

    public static void main(String[] args) {
        // 애초에 다른 타입이기 때문에 비교 불가
        // Operator '==' cannot be applied to 'FRUIT1', 'COMPANY1'
//        if(Fruit.APPLE == Company.APPLE) {
//            System.out.println("과일 애플과 회사 애플이 같다.");
//        }

        Fruit1 type = Fruit1.APPLE;
        switch (type) {
            case APPLE: System.out.println("사과"); break;
            // 다른 타입이기 때문에 비교 자체 불가
//            case GOOGLE: System.out.println("사과"); break;
            case PEACH: System.out.println("복숭아"); break;
            case BANANA: System.out.println("바나나"); break;
        }
    }
}

enum Fruit1 {
    APPLE, PEACH, BANANA;
}

enum Company1 {
    GOOGLE, APPLE, ORACLE;
}
```

---

- enum은 클래스 이기 때문에 생성자를 가질 수 있다.
- 즉, Fruit2 type = Fruit2.APPLE;를 할 때 생성자가 실행 되며, CallConstructor가 3번 출력 된다.
```java
enum Fruit2{
    APPLE, PEACH, BANANA;
    Fruit2(){
        System.out.println("Call Constructor "+this);
    }

    // enum은 생성자 접근제어자가 private이기 때문에 컴파일 에러
//    public Fruit2(){
//        System.out.println("Call Constructor "+this);
//    }
}

enum Company2{
    GOOGLE, APPLE, ORACLE;
}

public class EnumTest7 {

    public static void main(String[] args) {
     
        /*
        if(Fruit.APPLE == Company.APPLE){
            System.out.println("과일 애플과 회사 애플이 같다.");
        }
        */
        Fruit2 type = Fruit2.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal");
                break;
            case PEACH:
                System.out.println(34+" kcal");
                break;
            case BANANA:
                System.out.println(93+" kcal");
                break;
        }
    }
}
```

---

- enum에 인스턴스 필드 부여하기
```java
enum Fruit3{
    // APPLE, PEACH, BANANA는
    // public static finale APPLE = new Fruit3("red");와 같다.
    APPLE("red"), PEACH("pink"), BANANA("yellow");

    private String color;
    Fruit3(String color){
        System.out.println("Call Constructor "+ this);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

enum Company3{
    GOOGLE, APPLE, ORACLE;
}

public class EnumTest8 {

    public static void main(String[] args) {
        Fruit3 type = Fruit3.APPLE;
        switch(type){
            case APPLE:
                System.out.println(57+" kcal, " + Fruit3.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34+" kcal," + Fruit3.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(93+" kcal, " + Fruit3.BANANA.getColor());
                break;
        }
    }
}
```

---

- enum은 class이다.
- 편의를 위해서 enum만을 위한 문법적 형식을 가지고 있기 때문에 구분하기 위해서 enum이라는 키워드를 사용하는 것 이다.

- 두 코드는 서로 같은 코드이다.
```java
enum Fruit {
    APPLE, PEACH, BANANA;
}
```
```java
class Fruit {
    public static final Fruit APPLE  = new Fruit();
    public static final Fruit PEACH  = new Fruit();
    public static final Fruit BANANA = new Fruit();
    private Fruit() {}
}
```
코드 설명을 하자면,
생성자 접근제어자가 private인데 이는 다른 용도로 사용을 금지하기 위해서 이다.
이게 무슨 뜻이냐 하면, 타입 체크를 위해 자신의 인스턴스를 자신이 생성하여 가지고 있겠다는 뜻이다.
즉, APPLE, PEACH, BANANA는 인스턴스인 것 이다.
결국 외부에서는 절대 생성을 할 수 없는 것 이다.

---
### 위의 결과로 enum의 장점
- 코드가 단순해진다.
- 인스턴스 생성과 상속을 방지한다.(상속이 되기 위해서는 super()가 반드시 필요하니까)
- enum 키워드로 열거형이라는 것을 명확히 알 수 있다.



