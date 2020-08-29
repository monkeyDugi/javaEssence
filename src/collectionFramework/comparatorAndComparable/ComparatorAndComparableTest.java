package collectionFramework.comparatorAndComparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort()에서 알아서 정렬을 해주는 것 같지만 실체는 Comparable의 구현에 의해 정렬이 된 것 이다.
 */
public class ComparatorAndComparableTest {

    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); // String의 Comparable 구현에 의한 정렬, Comparable을 지정하지 않으면 저장하는 객체의 Comparable을 구현한 클래스의 객체에 구현된 내용에 따라 정렬된다.
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 역순 정렬
        System.out.println("strArr = " + Arrays.toString(strArr));
    }
}

class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable)o1;
            Comparable c2 = (Comparable)o2;
            return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬방식의 역으로 변경
                                           // 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 된다.
        }
        return -1;
    }
}
