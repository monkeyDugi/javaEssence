# TreeSet

- 이진 검색 트리(binary search tree)라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스
- 정렬, 검색, 범위검색에 높은 성능을 보임
- 이진 검색 트리의 성능을 향상시킨 레드-블랙-트리로 구현되어 있다.
- 중복x, 순서x(Set 인터페이스 구현)

- 링크드리스트처럼 여러개의 노드가 서로 연결된 구조로, 각 노드에 최대 2개의 노드를 연결할 수 있으며
  루트 노드에서부터 시작해서 계속 확정 가능.
- 위(부모) 아래(자식)로 연결된 두 노드를 부모-자식 관계에 있다고 함.
```java
class TreeNode {
    TreeNode left;  // 왼쪽 자식 노드
    Object element; // 객체를 저장하기 위한 참조변수
    TreeNode right; // 오른쪽 자식노드
}
```
- 부모 노드의 왼쪽에는 자신보다 작은 값의 자식노드, 오른쪽에는 큰 값의 자식노드를 저장하는 이진트리 구조
- 첫 번째 저장되는 값은 루트, 두 번째 값은 트리의 루트부터 시작해서 값의 크기를 비교하면서 트리를 따라 내려감.
- 이렇게 자장되면 왼쪽 마지막 레벨이 제일 작은 값, 오른쪽 마지막 레벨이 가장 큰 값이 된다.
- TreeSet에 저장되는 객체가 Comparable을 구현하던가 아니면, Comparaotr를 제공해서 두 객체를 비교할 방법을 알려줘야 한다.
  그렇지 않으면 두 번째 객체를 저장할 때 에러 발생.
- 왼쪽 마지막 값에서부터 오른쪽 값까지 값을 왼쪽 노드 -> 부모 노드 -> 오른쪽 노드 순으로 읽어오면 오름차순으로
  정렬된 순서를 얻을 수 있다. 즉, 정렬된 상태를 유지하기 때문에 단일 값 검색과 범위 검색에 빠르다.
  예로 3과 7사이의 범위에 있는 값 검색이 매우 빠른 것.
- 순차적 저장이 아니므로 저장 위치를 찾아서 저장해야 하고, 
- 삭제는 트리의 일부를 재구성해야 하므로 링크드 리스트 보다 데이터의 추가/삭제가 늦다.
- 단, 배열이나 링크드 리스트에 비해 검색과 정렬기능이 뛰어나다.

> **이진 검색 트리(binary search tree)** <br/>
>모든 노드는 최대 두 개의 자식노드를 가질 수 있다.
>왼쪽 자식노드의 값은 부모노드의  값 보다 작고, 오른쪽 자식 노드의 값은 부모 노드의 값 보다 커야한다.
>노드의 추가 삭제에 시간이 걸린다(순차적으로 저장하지 않으므로)
>검색(범위검색)과 정렬에 유리
>중복 값 저장 못함