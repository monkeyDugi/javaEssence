## 다형성

### 참조변수의 형변환
- 조상 <-> 자손일 경우만 형변환이 가능하다.(상속)
- 바로 윗 조상, 바로 아랫 자손이 아닌 모든 조상, 자손간에 가능하다. 
  즉, 모든 클래스의 조상인 **Object** 클래스 타입으로 형변환이 가능하다.
- 조상 -> 자손으로 형변환 하는 것은 위험한 행위이다.
  조상의 멤버 <= 자손의 멤버 이기 때문에 자손에 존재하는 멤버를 사용할 수 없을 수도 있기 때문이다.
  
  <br/><br/><br/>
  **중요하지 않음**
 - 자손타입 -> 조상타입(Up-casting) : 형변환 생략가능

 - 자손타입 <- 조상타입(Down-casting) : 형변환 생략불가

## 핵심은 형변환이 되느냐 안되느냐가 아니라, 참조하는 인스턴스(객체)가 무엇이냐가 중요한 것 이다.

## 특징
1. 다형성의 기본 특징
```java 
(조상)TV tv = (자식)new SmartTv();      // 가능
(자식)SmartTv smartTv = new Tv();(조상) // 불가
```

2. 참조변수의 형변환
```java
(자식)SmartTv smartTv = (SmartTv)(new Tv();(조상) // 형변환으로 인해 가능
```


3. instanceof 연산자
- 형변환 가능여부를 체크
- 즉, 조상, 자존 관계인지 체크

4. 매개변수의 다형성
- 예를 들자면, 이미 정의되어 있는 **PrintStream, String** 클래스를 보면 알 수 있다.
```java
// 매개변수 타입이 Object이므로 모든 타입을 받을 수 있고, valueOf를 이용해 null 또는 toString을 return 해준다.
public void print(Object obj) {
        write(String.valueOf(obj));
    }

public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}
```

  