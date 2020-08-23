# Object 클래스의 hashCod()와 eqluas()

- hashCode는 객체의 주소를 int로 반환하는 메서드이다
- native란 OS의 메서드로 C언어로 작성되어 있어 내용을 볼 수는 없다.
```java
public class object {
    public native int hashCode();
}
```
- equasl()를 오버라이딩 하면, hashCode()도 오버라이딩 해야한다.
  -> equals() 결과가 true인 객체의 hashCode는 같아야하기 때문이다.
- 원래 equlas()도 주소를 비교하지만 자동으로 오버라이딩 되어서 따로 처리를 해주지 않아도 되는 것 이다.
  -> 결국 객체의 값으 가지고 비교할 수 있게 하는 것 이다.(인스턴스 변수를 사용할 수 있도록!)
- 주소비교가 아닌 값 비교를 위해서 오버라이딩 해야하는 이유는 Object클래스에서 equals()는 아래와 같기 때문이다.
```java
// 오브젝트 클래의 equals는 아래와 같이 주소를 비교하게 되어있다. 
   public boolean equals(Object obj) {
    return (this == obj);
   }
```