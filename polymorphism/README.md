## 다형성

### 참조변수의 형변환
- 조상 <-> 자손일 경우만 형변환이 가능하다.(상속)
- 바로 윗 조상, 바로 아랫 자손이 아닌 모든 조상, 자손간에 가능하다. 
  즉, 모든 클래스의 조상인 **Object** 클래스 타입으로 형변환이 가능하다.
- 조상 -> 자손으로 형변환 하는 것은 위험한 행위이다.
  조상의 멤버 <= 자손의 멤버 이기 때문에 자손에 존재하는 멤버를 사용할 수 없을 수도 있기 때문이다.
  
 > 자손타입 -> 조상타입(Up-casting) : 형변환 생략가능

 > 자손타입 <- 조상타입(Down-casting) : 형변환 생략불가


#핵심은 형변환이 되느냐 안되느냐가 아니라, 참조하는 인스턴스(객체)가 무엇이냐가 중요한 것 이다. 