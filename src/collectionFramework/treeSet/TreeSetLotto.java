package collectionFramework.treeSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * HashSet을 사용하여 만들 때는 정렬을 따로 해주어야 하는데 TreeSet은 저장 시 정렬이 되기 때문에 안해도 된다.
 */
public class TreeSetLotto {

    public static void main(String[] args) {
        Set set = new TreeSet();

        for (int i = 0; set.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            set.add(num); // set.add(new Integer(num));
        }

        System.out.println(set);
    }
}
