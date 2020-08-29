package collectionFramework.hashSet;

import java.util.*;

/**
 * HashSet의 중복불가를 이용하여 로또번호 생성
 */
public class HashSetLotto {

    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int)(Math.random() * 45) + 1;
            set.add(new Integer(num));
        }

        // LinkedList(Collection c)
        // Collections.sort(List list)는 List 타입을 필요로 하므로 LinkedList()의 생성자에 HashSet을 넘겼다.
        List list = new LinkedList(set);
        // 번호를 크기 순 정렬을 위해 Collections.sort(List list)
        // HashSet에 저장된 객체가 Integer이기 때문에 Integer클래스에 정의된 기본 정렬이 사용된다.
        // Collections : 클래스임!!
        Collections.sort(list);

        System.out.println(list);
    }
}
