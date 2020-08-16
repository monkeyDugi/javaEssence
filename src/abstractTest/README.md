# 추상 클래스

## 추상 클래스와 추상 메서드
### 추상 클래스
- 미완성 설계도로써, 바디가 없는 추상 메서드를 가지고 있는 클래스이다.
- 미완성이기 때문에 객체 생성이 불가
- 자손 클래스에서 구현하여 자손 클래스의 인스턴스를 사용가능
#### 굳이 추상 클래스를 사용하는 이유
- 필수기능을 부여, 공통 기능 부여
  -> 공통 부분을 추상 클래스로 만든다는 말과 같다.
  -> 오버라이딩 하는 것은 일반 클래스와 다를게 없어 보이지만, 일반 클래스로 바디에 내용이 없이 오보라이딩 하여 사용하는 것은
     실수로 오버라이딩 하지 않고, 사용할 수 있으므로 추상클래스로 **공통** 부분을 만들어 주는 것 이다.
- 공통기능 수정 시 추상 메서드만 모두 바꾸는 것이 아닌 구현부 하나만
- 추상 메서드가 반드시 있어야 한다는 것을 제외하면 일반 클래스와 다를게 없다.
  -> 추상 메서드가 아닌 일반 메서드가 있어도 된다는 것.
  -> **공통**기능으로 일반 메서드로 사용할 수 있다.

### 추상 메서드
- 추상클래스가 가지고 있는 미완성 메서드로 추상클래스를 상속 받고 완성된 클래스로 사용하기 위해서는
  반드시 오바라이딩하여 구현을 해주어야 한다.