package collectionFramework.hashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
        Set set = new HashSet();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]); // HashSet에 objArr의 요소들을 저장한다.
        }
        // 결과를 보면 중복은 허용되지 않고, String : 1, Integer : 1은 다르므로 중복이 아니어서 저장 된다.
        // 저장한 순서를 유지하지 않으므로 순서가 다를 수도 있다.
        System.out.println(set);
    }
}
