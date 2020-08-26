# Iterator interface
- 컬렉션 프레임워크에서 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 인터페이스
ex) Set, List는 읽어오는 방식이 다른데 Iterator를 사용하면 동일하게 읽어올 수 있다.
```java
        List list = new ArrayList();
        list.add("ddd");
        list.add("CCC");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
```
위와 같이 new ArrayList() 부분만 바꾸어주면 동일한 코드로 읽어올 수 있는 것 이다.
참조타입을 List로 한 이유는 어떠한 이유로 List인터페이스를 구현한 다른 클래스를 사용한다고 하면(LinkedList) 
ArrayList 참조타입으로 했을 꼉우는 아래 코드들에서 ArrayList만의 기능을 사용하는지 검토가 필요하지만,
List 참조타입은 List 의 기능만 있기 때문에 LinkedList가 들어와도 검토할 필요가 없게 되는 것 이다.

- Map 인터페이스의 iterator() 호출
  - Map은 key, value 쌍으로 호출이 불가하여, Set형태로 얻어온 후 호출해야 한다.
```java
Map map = new HashMap();
...
Iterator it = map.keySet().iterator();
```
위의 **Iterator it = map.keySet().iterator();** 문장은 아래의 두 문장을 하나로 합친 것 이다.
```java
Set eSet = map.entrySet();
Iterator list = eSet.iterator();
```