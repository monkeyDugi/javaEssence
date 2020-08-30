package collectionFramework.treeSet;

import java.util.TreeSet;

/**
 * headSet고가 tailSet을 이용한 검색
 */
public class TreeSetEx2 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        int [] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(new Integer(score[i]));
        }
        // 50 포함 x
        System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
        // 50 포함 o
        System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
    }
}
