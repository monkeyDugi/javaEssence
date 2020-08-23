package collectionFramework.arrayList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ArrayList 테스트
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);

        list1.add(new Integer(5));
        // add(Object obj) 타입이라 원래는 불가능 하지만 오토박싱에 의해서 자동으로 Integer객체로 변환
        list1.add(4);
        list1.add(new Integer(6));
        list1.add(new Integer(3));
        list1.add(new Integer(2));

        // 필요한 내용만 뽑아서 리스트 생성
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        print(list1, list2);

        // 정렬
        // Collection 인터페이스를 정렬할 때는 Collections 클래스를 사용하단ㄷ.
        // 디폴트 오름차순
        Collections.sort(list1);
        Collections.sort(list2);
        print(list1, list2);

        // list2의 내용이 모두 list1에 있는가
        System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));

        // 사이에 넣기
        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        print(list1, list2);

        // 수정하기
        list2.set(3, "AA");
        print(list1, list2);

        // indexOf : 앞에서 부터 찾
        list1.add(0, "6");
        print(list1, list2);
        // String인 6을 찾고
        System.out.println("index : " + list1.indexOf("6"));
        // Integer인 6을 찾음
        System.out.println("index : " + list1.indexOf(6));

        // 삭제하기
        // 인덱스로 해서 0번째가 지워짐
//        list1.remove(0);
        // 객체로 해서 숫자가 지워짐
        list1.remove(new Integer(6));
        print(list1, list2);

        // list1에서 list2와 겹치는 부분을 빼고 모두 제거한다.
        System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
        print(list1, list2);

        // list2에서 list1에 포함된 객체 삭제
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (list1.contains(list2.get(i))) {
               list2.remove(i);
            }
        }
        print(list1, list2);
    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
