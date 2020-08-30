# 컬렉션 클래스 정리
ArrayList
- 배열기반, 데이터의 추가와 삭제에 불리
- 순차적 추가 삭제는 제일 빠름
- 임의의 요소에 대한 접근성이 뛰어남

LinkedList
- 연결기반
- 데이터의 추가오 삭제에 유리
- 임의의 요소에 대한 접근성이 좋지 않다.

HashMap
- 배열과 연결이 결합된 형태
- 추가, 삭제, 검색, 접근성이 모두 뛰어남
- 검색에는 최고성능을 보임


TreeMap
- 연결기반.
- 정렬과 검색(특히 범위검색)에 적합
- 검색성능은 HashMap보다 떨어짐

Stack
- Vector를 상속받아 구현

Queue
- LinkedList가 Queue인터페이스를 구현

Properteis
- Hashtable을 상속받아 구현

HashSet
- HashMap을 이용해서 구현

TreeSet
- TreeMap을 이용해서 구현

LinkedHashMap
LinkedHashSet
- HashMap과 HashSet에 저장순서유지기능 추가