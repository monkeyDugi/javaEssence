package collectionFramework.hashSet;

import sun.print.resources.serviceui_zh_TW;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * 순서를 가지기 위해 HashSet이 아닌 LinkedHashSet 사용
 * 빙고게임
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {
        // HashSet의 특별한 저장 방식으로 비슷한 위치에 같은 숫자가 나오는 사실을 발견할 수 있따.
        // 이런 상황에는 순차 저장인 LinkedHashset이 낫다.
        // 하지만 나는 왜 못느끼겠지??(비슷한 위치에 같은 숫자가)
        Set set = new HashSet();
//        Set set = new LinkedHashSet();
        int [][] board = new int [5][5];

        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 50) + 1 + "");
        }

        Iterator it = set.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
