# 지네릭스
- 타입의 안정성을 제공
- 타입체크와 형변환을 생략할 수 있으므로 코드가 간결
- 즉 객체타입을 미리 명시해줌으로써 번거로운 형변황늘 줄여준다는 뜻

## 제네릭의 클래스 선언
- 클래스와 메서드에 선언
1. 클래스 선언
```java
// 기본 클래스
class Box {
    Objet item;
    void setItem(Object item) {
        this.item = item;
    }
    Object getItem() {
        return item;
    }
}

// 제네릭스를 반영한 클래스
class Box<T> { // 제네릭 타입 T를 선언
    T item;
    void setItem(T item) {
        this.item = item;
    }
    T getItem() {
        return item;
    }
}
```

## 제네릭스의 제한
- 모든 객체가 동일하게 사용해야 하는 static에는 사용할 수 없다.
- 참조변수 배열 선언은 각능하지만 생성을 불가능 하다.
  -> new 연산자 때문인데, 이 연산자는 컴파일 시점에 타입 T가 뭔지 정확히 알아야 하기 때문이다.
  
## 제네릭 메서드
- 메서드에 정의된 타입 매개변수는 클래스에 정의된 타입 매개변수와 전혀 무관(제네릭 메서드는 클래스가 아닌 클래스에도 정의 가능, **static <T> void**)
- static 메서드에는 원래 타입 매개변수가 사용 불가하지만, 메서드에(static <T>)를 선언하고 사용이 가능 
```java
static <T> void sort (List<T> list, Comparator<? super T> c)
```
- FruitBoxEx3.java에서 makeJuice()를 와일드 카드로 사용 했었다. 왜냐? static에는 타입 매개변수 사용이 불가능 하기 때문에
하지만
```java
class Juicer {

    static Juice makeJuice(FruitBox<? extends Fruit2> box) {
        String tmp = "";

        for (Fruit2 f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
```
이 코드를 아래와 같이 변경 가능
```java
class Juicer {

    static <T extends Fruit2> Juice makeJuice(FruitBox<T> box) {
        String tmp = "";

        for (Fruit2 f : box.getList()) {
            tmp += f + " ";
        }
        return new Juice(tmp);
    }
}
```
